package com.example.springphonebook.phone;

import com.example.springphonebook.person.PersonEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    CommandLineRunner phoneSampleData(PhoneRepository phoneRepository ){
        return args -> {
            PhoneEntity phoneNumberType=new PhoneEntity(
            "09373886674",
            "phoneNumberType"
                    );

            phoneRepository.save(phoneNumberType);
        };

    }

}
