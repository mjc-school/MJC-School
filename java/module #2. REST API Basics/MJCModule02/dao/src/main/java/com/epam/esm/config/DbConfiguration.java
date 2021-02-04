package com.epam.esm.config;


import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.esm")
public class DbConfiguration {
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/module02?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "24081984";


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        driverManagerDataSource.setUrl(DB_URL);
        driverManagerDataSource.setUsername(USER_NAME);
        driverManagerDataSource.setPassword(PASSWORD);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
