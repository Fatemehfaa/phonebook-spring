package com.example.springphonebook.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository){
        return args ->{
            PersonEntity fatemeh = new PersonEntity(
                    "fatemeh",
                    "fathalian",
                    "0024444444"
            );

            PersonEntity sanaz = new PersonEntity(
                    "sanaz",
                    "bakhshi",
                    "001111111111"
            );

            personRepository.saveAll (List.of (fatemeh,sanaz));

        };
    }
}
