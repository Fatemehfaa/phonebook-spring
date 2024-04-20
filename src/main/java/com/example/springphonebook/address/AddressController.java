package com.example.springphonebook.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/create/" )
    public ResponseEntity<AddressEntity> createAddress(@RequestBody AddressEntity address){
        addressService.CreateAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/loadAddressById/{id}")
    public ResponseEntity <AddressEntity>loadAddressById(@PathVariable Long id){
        AddressEntity addressEntity = addressService.LoadAddressEntityByID(id);
        return new ResponseEntity<>(addressEntity, HttpStatus.OK);
    }

    @GetMapping("/getAllAddress/")
    public ResponseEntity <List<AddressEntity>> getAllAddress(){
        List<AddressEntity> allAddress = addressService.getAllAddress();
        return new ResponseEntity<>(allAddress,HttpStatus.OK);
    }

    @GetMapping("/getAddressByCityname/{cityname}")
    public ResponseEntity <AddressEntity> getAddressByCityname(@PathVariable String cityname){
        AddressEntity addressByIdCityName = addressService.getAddressByIdCityName(cityname);
        return new ResponseEntity<>(addressByIdCityName , HttpStatus.OK);

    }

}