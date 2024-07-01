package com.example.springphonebook.address;

import org.assertj.core.api.Assertions;
import org.hibernate.query.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
     void AddressService_CreateAddress_ReturnAddress() {
        AddressEntity buildAddress = AddressEntity.builder()
                .cityName("Tehran")
                .build();

        AddressDto addressDto = AddressDto.builder()
                .cityName("Teh")
                .build();

        when(addressRepository.save(Mockito.any(AddressEntity.class))).thenReturn(buildAddress);

        Assertions.assertThat(buildAddress).isNotNull();


    }


}
