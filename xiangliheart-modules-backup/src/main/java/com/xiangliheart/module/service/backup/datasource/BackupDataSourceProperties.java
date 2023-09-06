/**
 * Copyright (c) 2023-2023 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.module.service.backup.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * BackupDataSourceProperties 数据源
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2023/1/4
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "xiangliheart.backup.datasource")
public class BackupDataSourceProperties {
    private String host;
    private String userName;
    private String password;
    private String database;
}