/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig 跨域配置类
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/9
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径
        registry.addMapping("/**")
            // 允许跨域访问的源
            .allowedOriginPatterns("*")
            // 允许请求方法
            .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
            // 预检间隔时间
            .maxAge(168000)
            // 允许头部设置
            .allowedHeaders("*")
            // 是否发送cookie
            .allowCredentials(true);
    }
}
