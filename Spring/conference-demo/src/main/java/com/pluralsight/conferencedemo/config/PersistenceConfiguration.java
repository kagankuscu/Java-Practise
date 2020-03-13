package com.pluralsight.conferencedemo.config;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PersistenceConfiguration
 */
@Configuration
public class PersistenceConfiguration {

    // it gives error.
    // @Bean
    // public DataSource dataSource() {
    //     DataSourceBuilder builder = DataSourceBuilder.create();
    //     builder.url("jdbc:sqlserver://localhost:1433/conference_app");
    //     System.out.println("My custom datasource bean has been initialized and set up.");
    //     return builder.build();
    // }
}