package com.example.springphonebook.person;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void PersonRepository_saveAll_ReturnSavedPerson() {
        PersonEntity build = PersonEntity.builder()
                .firstname("amir")
                .surname("amiri")
                .nationalCode("123456")
                .build();
        PersonEntity save = personRepository.save(build);
        Assertions.assertThat(save).isNotNull();
    }

    @Test
    void PersonRepository_Update_ReturnUpdatedPerson() {
        PersonEntity person = PersonEntity.builder()
                .firstname("amir")
                .surname("amiri")
                .nationalCode("123456")
                .build();
     personRepository.save(person);

     person = personRepository.findById(person.getId()).get();
     person.setFirstname("amir2");
     person.setSurname("amiri2");
     person.setNationalCode("1234");
     PersonEntity updateSave = personRepository.save(person);
     Assertions.assertThat(updateSave).isNotNull();
    }


    @Test
    void personRepository_Delete_ReturnDeletedPerson() {
        PersonEntity person = PersonEntity.builder()
                .firstname("amir")
                .surname("amiri")
                .nationalCode("123456")
                .build();
        personRepository.save(person);
        personRepository.deleteById(person.getId());
        Optional<PersonEntity> personRepositoryById = personRepository.findById(person.getId());
        Assertions.assertThat(personRepositoryById.isEmpty()).isNotNull();

    }


}
