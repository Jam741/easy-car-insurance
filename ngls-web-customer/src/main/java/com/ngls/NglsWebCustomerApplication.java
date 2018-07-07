package com.ngls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ngls"})
@EnableJpaRepositories(basePackages = {"com.ngls.user.dao"})
@EntityScan(basePackages = {"com.ngls.user.domain"})
@SpringBootApplication
public class NglsWebCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NglsWebCustomerApplication.class, args);
    }
}
