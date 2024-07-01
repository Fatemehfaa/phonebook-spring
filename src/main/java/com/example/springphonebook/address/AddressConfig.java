package com.example.springphonebook.address;

import com.example.springphonebook.person.PersonEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AddressConfig {

    @Bean
    CommandLineRunner addressSampleData(AddressRepository addressRepository){
        return args -> {
            AddressEntity mirdamad = new AddressEntity(
                    "mirdamad",
                    "tehran",
                    367,
                    PersonEntity.builder()
                            .firstname("amir")
                            .surname("amiri")
                            .nationalCode("123")
                            .build()

                    );

            addressRepository.save(mirdamad);


        };
    }
}
