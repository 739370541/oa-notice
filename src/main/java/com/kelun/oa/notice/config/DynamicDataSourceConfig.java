//package com.kelun.oa.notice.config;
//
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@PropertySource("classpath:config/jdbc.properties")
//@MapperScan(basePackages = "me.mason.demo.dynamicdatasource.mapper")
//public class DynamicDataSourceConfig {
//    @Bean("mysql")
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("sqlserver")
//    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
