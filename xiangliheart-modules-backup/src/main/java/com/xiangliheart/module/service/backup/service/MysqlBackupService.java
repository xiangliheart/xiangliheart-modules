/**
 * Copyright (c) 2023-2023 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.module.service.backup.service;

/**
 * MysqlBackupService MySql命令行备份恢复服务
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2023/1/4
 */
public interface MysqlBackupService {

    /**
     * backup 备份数据库
     *
     * @param host host地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param savePath 备份的路径
     * @param fileName 备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2023/1/4
     */
    boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
        String database) throws Exception;

    /**
     * 恢复数据库
     * 
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2023/1/4
     */
    boolean restore(String restoreFilePath, String host, String userName, String password, String database)
        throws Exception;
}
