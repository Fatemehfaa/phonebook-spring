package com.example.springphonebook.person;

import com.example.springphonebook.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(PersonEntity person) {
        boolean b = Validation.validationNationalCode(person.getNationalCode());
        if(! b)
            throw new RuntimeException("NationalCode is not valid .");
        this.personRepository.save(person);
    }

    @Override
    public PersonEntity getPerson(Long id) {
        PersonEntity personEntity = personRepository.findById(id).get();
        if (personEntity !=null)
            return personEntity;
        else
            throw new RuntimeException("Id Not Found.");
    }

    @Override
    public List<PersonEntity> getAll() {
        List<PersonEntity> all = personRepository.findAll();
        if(all.isEmpty())
            return null;
        return all;
    }

    @Override
    public PersonEntity getPersonByNationalCode(String nationalCode) {
        PersonEntity personEntityByNationalCode = personRepository.getPersonEntityByNationalCode(nationalCode);
        if(personEntityByNationalCode == null)
            throw new RuntimeException("National Code not found...");
        return personEntityByNationalCode;
    }

    @Override
    public List<PersonEntity> getPersonByFirstName(String firstName) {
        List<PersonEntity> personEntityByFirstname = personRepository.getPersonEntityByFirstname(firstName);
        if (personEntityByFirstname.isEmpty())
            throw new RuntimeException("firstname not found.");
        return personEntityByFirstname;
    }

    @Override
    public List<PersonEntity> showPerson() {
        return List.of(new PersonEntity(
                "fatemeh",
                "fathalian",
                "0024444444"));

    }
}
