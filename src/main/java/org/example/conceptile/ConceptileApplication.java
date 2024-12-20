package org.example.conceptile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
@EntityScan("org.example.conceptile")
public class ConceptileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConceptileApplication.class, args);
    }

}

// hello world
