package com.example.springphonebook.address;

import com.example.springphonebook.person.PersonEntity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Configuration
public class AddressConfig {

    @Bean
    CommandLineRunner commandLineRunner(AddressRepository addressRepository){
        return args -> {
            AddressEntity mirdamad = new AddressEntity(
                    "mirdamad",
                    "tehran",
                    367,
                    new PersonEntity()

                    );

            addressRepository.save(mirdamad);


        };
    }
}
