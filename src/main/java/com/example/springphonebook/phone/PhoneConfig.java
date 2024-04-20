package com.example.springphonebook.phone;

import com.example.springphonebook.person.PersonEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {
    @Bean
    CommandLineRunner commandLineRunner(PhoneRepository phoneRepository ){
        return args -> {
            PhoneEntity phoneNumberType=new PhoneEntity(
            "09373886674",
            "phoneNumberType"
                    );

            phoneRepository.save(phoneNumberType);

        };

    }

}
