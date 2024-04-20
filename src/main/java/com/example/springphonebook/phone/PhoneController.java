package com.example.springphonebook.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/phone")
public class PhoneController {
   private PhoneService phoneService;
    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/save/")
    public ResponseEntity<PhoneEntity> savePhone(@RequestBody PhoneEntity phone){
        phoneService.createPhone(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getPhoneById/{id}")
    public ResponseEntity<PhoneEntity> getPhoneById(@PathVariable Long id){
        PhoneEntity phoneById = phoneService.getPhoneById(id);
        return new ResponseEntity<>(phoneById,HttpStatus.OK);
    }

    @GetMapping("/getAllPhone/")
    public ResponseEntity<List<PhoneEntity>> getAllPhone(){
        List<PhoneEntity> allPhone = phoneService.getAllPhone();
        return new ResponseEntity<>(allPhone,HttpStatus.OK);
    }

    @GetMapping("/getPhoneByPhoneNumber/{phoneNumber}")
    public ResponseEntity<PhoneEntity> getPhoneByPhoneNumber(@PathVariable String phoneNumber){
        PhoneEntity phoneByPhoneNumber = phoneService.getPhoneByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(phoneByPhoneNumber , HttpStatus.OK);

    }


    @RequestMapping(value = "/first" , method = RequestMethod.GET)
    public List<String> showhello(){
        return List.of("<h2>Hello</h2> , JSonForm");
    }

    @GetMapping("/showPhone")
    public ResponseEntity<List<PhoneEntity>> showPhone(){
        List<PhoneEntity> phoneEntities = phoneService.showPhone();
        return new ResponseEntity<>(phoneEntities,HttpStatus.OK);

    }







}
