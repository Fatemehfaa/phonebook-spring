package com.example.springphonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringPhoneBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPhoneBookApplication.class, args);
    }

}
