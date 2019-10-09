package com.market.sapphires.sbt.service.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.market.sapphires.sbt.entity.LoginUser;
import com.market.sapphires.sbt.repository.LoginUserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginUserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<LoginUser> users = this.dao.findByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        LoginUser user = users.get(0);

        return new User(user.getUsername(), user.getPassword(), user.getAuthorities().stream()
                .map(g -> new SimpleGrantedAuthority(g.getAuthority()))
                .collect(Collectors.toList()));
    }

}
