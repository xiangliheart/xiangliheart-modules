package com.xiangliheart.modules.frame.core.frame.security.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * GrantedAuthorityImpl 权限封装
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}