/**
 * Copyright (c) 2023-2023 xiangliheart(湘澧寸心) All rights reserved.
 */
package com.xiangliheart.module.service.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BackupApplication
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2023/1/4
 */
@SpringBootApplication(scanBasePackages = "com.xiangliheart.modules")
public class BackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackupApplication.class, args);
    }
}