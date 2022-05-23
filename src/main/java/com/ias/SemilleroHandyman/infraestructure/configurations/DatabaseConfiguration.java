package com.ias.SemilleroHandyman.infraestructure.configurations;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5434/handyman");
        hikariConfig.setUsername("postgres_user");
        hikariConfig.setPassword("postgres_password");
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    @Profile("test")
    public DataSource dataSourceTest() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5434/handymanTest");
        hikariConfig.setUsername("postgres_user");
        hikariConfig.setPassword("postgres_password");
        return new HikariDataSource(hikariConfig);
    }

}
