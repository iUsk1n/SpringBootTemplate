package com.market.sapphires.sbt.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;

public enum LoginUserPermission {
    /** */
    USER_SHOW("USER_SHOW"),
    /** */
    USER_EDIT("USER_EDIT");

    @Getter
    private GrantedAuthority authority;

    private LoginUserPermission(String authority) {
        this.authority = new SimpleGrantedAuthority(authority);
    }
}
