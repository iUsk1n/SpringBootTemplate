package com.market.sapphires.sbt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LoginUserGroup")
public class LoginUserGroup implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String authority;

    @Getter
    @Setter
    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH }, mappedBy = "authorities")
    private Set<LoginUser> users = new HashSet<>();

    @Getter
    @Setter
    @Version
    private int version;

}
