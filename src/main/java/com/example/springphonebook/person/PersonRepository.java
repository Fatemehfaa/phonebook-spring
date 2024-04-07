package com.example.springphonebook.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    public PersonEntity getPersonEntityByNationalCode(String nationalCode);
    public List<PersonEntity> getPersonEntityByFirstname(String firstName);
}
