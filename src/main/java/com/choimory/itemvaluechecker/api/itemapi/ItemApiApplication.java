package com.choimory.itemvaluechecker.api.itemapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemApiApplication.class, args);
    }

}
