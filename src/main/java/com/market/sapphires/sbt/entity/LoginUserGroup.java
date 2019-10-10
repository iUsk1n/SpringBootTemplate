package com.market.sapphires.sbt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LoginUserGroup")
public class LoginUserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.DETACH }, mappedBy = "groups")
    @Getter
    @Setter
    private Set<LoginUser> users = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Set<LoginUserPermission> permissions = new HashSet<>();

    @Version
    @Getter
    @Setter
    private int version;

}
