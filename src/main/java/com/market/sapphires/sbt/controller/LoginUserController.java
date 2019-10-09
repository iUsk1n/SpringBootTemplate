package com.market.sapphires.sbt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.sapphires.sbt.repository.LoginUserDao;
import com.market.sapphires.sbt.repository.LoginUserGroupDao;
import com.market.sapphires.sbt.service.LoginUserService;

@Controller
@RequestMapping(value = "/users")
public class LoginUserController {

    @Autowired
    private LoginUserService service;

    @Autowired
    private LoginUserDao uRepository;

    @Autowired
    private LoginUserGroupDao aRepository;

    @PostConstruct
    public void init() {
        /*
        LoginUserGroup aUsers = new LoginUserGroup();
        aUsers.setAuthority("Users");
        this.aRepository.saveAndFlush(aUsers);
        
        LoginUserGroup aAdmin = new LoginUserGroup();
        aAdmin.setAuthority("Administrators");
        this.aRepository.saveAndFlush(aAdmin);
        
        // 現在日時
        long now = Instant.now().toEpochMilli();
        
        LoginUser admin = new LoginUser();
        admin.setUsername("test");
        admin.setPassword(new BCryptPasswordEncoder().encode("test"));
        admin.setEnabled(true);
        admin.setCreatedDate(now);
        admin.setUpdatedDate(now);
        admin.getAuthorities().add(aAdmin);
        this.uRepository.save(admin);
        
        LoginUser user = new LoginUser();
        user.setUsername("hoge");
        user.setPassword(new BCryptPasswordEncoder().encode("hoge"));
        user.setEnabled(true);
        user.setCreatedDate(now);
        user.setUpdatedDate(now);
        user.getAuthorities().add(aUsers);
        this.uRepository.save(user);
        */
    }

    @GetMapping(value = { "", "/", "/list" })
    public String list(Model model) {
        //
        return "users/list";
    }

}
