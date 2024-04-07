package com.example.springphonebook.person;

import java.util.List;

public interface PersonService {
    public void savePerson(PersonEntity person);
    public PersonEntity getPerson(Long id);
    public List<PersonEntity> getAll();


    public PersonEntity getPersonByNationalCode(String nationalCode);

    public List<PersonEntity> getPersonByFirstName(String firstName);

}
