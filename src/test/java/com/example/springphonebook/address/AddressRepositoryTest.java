package com.example.springphonebook.address;

import com.example.springphonebook.person.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    void Check_Address_Not_Null() {

        AddressEntity addressEntity = AddressEntity.builder()
                .cityName("tehran")
                .street("zafar")
                .plaque(140)
                .build();

        AddressEntity saveAddress = addressRepository.save(addressEntity);

        Assertions.assertNotNull(saveAddress);

    }

    @Test
    void CheckAddress_Equals_ReturnAddressEntity() {

        AddressEntity addressEntity = AddressEntity.builder()
                .cityName("tehran")
                .street("zafar")
                .plaque(140)
                .build();
        AddressEntity saveAddress = addressRepository.save(addressEntity);

        Assertions.assertEquals(saveAddress.getCityName(), addressEntity.getCityName());
    }


    @Test
    void Address_FindById_ReturnAddressEntity() {
        AddressEntity addressEntity = AddressEntity.builder()
                .cityName("tehran")
                .street("zafar")
                .plaque(140)
                .build();
        AddressEntity save = addressRepository.save(addressEntity);
        AddressEntity addressEntity1 = addressRepository.findById(save.getId()).get();
        assertThat(addressEntity1).isNotNull();
    }

    @Test
    void Address_ReturnAddressNotNull(){
        AddressEntity addressEntity = AddressEntity.builder()
                .cityName("tehran")
                .street("zafar")
                .plaque(140)
                .person(new PersonEntity())
                .build();
        AddressEntity save = addressRepository.save(addressEntity);
        addressRepository.deleteById(save.getId());
        Optional<AddressEntity> byId = addressRepository.findById(addressEntity.getId());
        assertThat(byId).isNotNull();

    }
}