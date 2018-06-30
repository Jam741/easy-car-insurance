package com.ngls.web.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableAutoConfiguration
@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.ngls")
@MapperScan(basePackages = {"com.ngls.user.dao"})
public class NglsWebCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NglsWebCustomerApplication.class, args);
    }
}
