package com.example.springphonebook.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping ("/save/")
    public ResponseEntity savePerson(@RequestBody PersonEntity person){
        personService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getPerson/{id}")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable Long id){
        PersonEntity person = personService.getPerson(id);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonEntity>> getAll(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getPersonByNationalCode/{nationalCode}")
    public ResponseEntity <PersonEntity> getPersonByNationalCode(@PathVariable String nationalCode){
        PersonEntity personByNationalCode = personService.getPersonByNationalCode(nationalCode);
        return new ResponseEntity<>(personByNationalCode,HttpStatus.OK);
    }

    @GetMapping("/getPersonByFirstname/{firstname}")
    public ResponseEntity<PersonEntity> getPersonByFirstname(@PathVariable String firstname){
        //List<PersonEntity> personByFirstName = personService.getPersonByFirstName(firstname);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
