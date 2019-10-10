package com.market.sapphires.sbt.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LoginUser")
public class LoginUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Column(unique = true)
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String fullname;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String comment;

    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Set<LoginUserGroup> groups = new HashSet<>();

    @Getter
    @Setter
    private boolean enabled;

    @Getter
    @Setter
    private boolean locked;

    @Getter
    @Setter
    private long createdDate;

    @Getter
    @Setter
    private long updatedDate;

    @Version
    @Getter
    @Setter
    private int version;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        this.groups.stream().forEach(g -> {
            g.getPermissions().forEach(p -> authorities.add(p.getAuthority()));
        });

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
