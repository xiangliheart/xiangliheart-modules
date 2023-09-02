/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * EobServerAuthApplication
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/2
 */
@SpringBootApplication(scanBasePackages = {"com.xiangliheart.general.platform"})
@MapperScan("com.xiangliheart.general.platform")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
