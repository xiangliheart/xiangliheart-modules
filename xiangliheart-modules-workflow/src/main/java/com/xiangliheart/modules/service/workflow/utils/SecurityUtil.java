/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.service.workflow.utils;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

/**
 * SecurityUtil
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/9/12
 */
@Slf4j
public class SecurityUtil {
    @Autowired
    @Qualifier("myUserDetailsService")
    private UserDetailsService userDetailsService;

    public void logInAs(String username) {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user == null) {
            throw new IllegalStateException("User " + username + " doesn't exist, please provide a valid user");
        }
        log.info("> Logged in as: " + username);
        SecurityContextHolder.setContext(new SecurityContextImpl(new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user.getAuthorities();
            }

            @Override
            public Object getCredentials() {
                return user.getPassword();
            }

            @Override
            public Object getDetails() {
                return user;
            }

            @Override
            public Object getPrincipal() {
                return user;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}

            @Override
            public String getName() {
                return user.getUsername();
            }
        }));
        org.activiti.engine.impl.identity.Authentication.setAuthenticatedUserId(username);
    }
}