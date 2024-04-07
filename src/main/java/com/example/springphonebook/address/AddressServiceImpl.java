package com.example.springphonebook.address;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public void CreateAddress(AddressEntity address) {
        this.addressRepository.save(address);

    }

    @Override
    public AddressEntity LoadAddressEntityByID(Long id) {
        Optional<AddressEntity> byId = addressRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            return null;
        // return addressRepository.findById(id).get();
    }

    @Override
    public List<AddressEntity> getAllAddress() {
        List<AddressEntity> all = addressRepository.findAll();
        if (all == null)
            throw new RuntimeException("Can not find Address.");
        else
            return all;
    }

    @Override
    public AddressEntity getAddressByIdCityName(String cityName) {
        AddressEntity addressEntityByCityName = addressRepository.getAddressEntityByCityName(cityName);
        return addressEntityByCityName;
    }
}