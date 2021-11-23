package com.switchfully.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.switchfully.order")
@EnableJpaRepositories("com.switchfully.order")
@EntityScan("com.switchfully.order")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
