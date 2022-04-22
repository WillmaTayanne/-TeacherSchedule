package com.pdist.teacherSchedule;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://ec2-52-86-56-90.compute-1.amazonaws.com:5432/d51knud2oa7a58");
        dataSourceBuilder.username("xrdsmdeiorccrc");
        dataSourceBuilder.password("87c6593a7a3cb48f13babdf188c43d0da564a650727f420caf8a3b680ca4960c");
        return dataSourceBuilder.build();
    }
}
