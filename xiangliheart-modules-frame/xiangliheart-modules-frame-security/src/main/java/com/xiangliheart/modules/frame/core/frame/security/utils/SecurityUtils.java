package com.xiangliheart.modules.frame.core.frame.security.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.xiangliheart.modules.frame.core.frame.security.security.JwtAuthenticatioToken;

/**
 * SecurityUtils Security相关操作
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/10
 */
public class SecurityUtils {

    /**
     * login 登录认证
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    public static JwtAuthenticatioToken login(HttpServletRequest request, String username, String password,
        AuthenticationManager authenticationManager) {
        JwtAuthenticatioToken token = new JwtAuthenticatioToken(username, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 执行登录认证过程
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证成功存储认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌并返回给客户端
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * checkAuthentication 获取令牌进行认证
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 获取令牌并根据令牌获取登录认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationeFromToken(request);
        // 设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * getUsername 获取当前用户名
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            }
        }
        return username;
    }

    /**
     * getUsername 获取用户名
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    public static String getUsername(Authentication authentication) {
        String username = null;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            }
        }
        return username;
    }

    /**
     * getAuthentication 获取当前登录信息
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/10
     */
    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
