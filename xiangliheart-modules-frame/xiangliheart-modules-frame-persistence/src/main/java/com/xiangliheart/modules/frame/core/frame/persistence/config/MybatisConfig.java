/**
 * Copyright (c) 2022-2022 xiangliheart(湘澧寸心) All rights reserved.
 */

package com.xiangliheart.modules.frame.core.frame.persistence.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * MybatisConfig
 *
 * @auther: xiangliheart(湘澧寸心)
 * @since: 2022/7/2
 */
@Configuration
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    /**
     * sqlSessionFactory
     *
     * @auther: xiangliheart(湘澧寸心)
     * @since: 2022/7/2
     * @return: SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.xiangliheart.eob.server.auth.entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:**/mapper/*.xml"));
        return sessionFactory.getObject();
    }
}