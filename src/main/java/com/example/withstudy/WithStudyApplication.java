package com.example.withstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WithStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WithStudyApplication.class, args);
    }

}
