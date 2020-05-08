package kgn.multimodule.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"kgn.multimodule"})
@EntityScan(basePackages = {"kgn.multimodule"})
public class MultiModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApplication.class, args);
    }
}
