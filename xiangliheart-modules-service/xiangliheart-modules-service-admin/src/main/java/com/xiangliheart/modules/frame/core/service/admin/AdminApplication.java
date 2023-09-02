/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * PlatformServiceAdminApplication
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/9/12
 */
@SpringBootApplication(scanBasePackages = {"com.xiangliheart.modules"})
@MapperScan("com.xiangliheart.modules.service.admin.dao")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
