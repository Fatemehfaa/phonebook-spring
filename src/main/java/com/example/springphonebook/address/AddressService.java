package com.example.springphonebook.address;

import java.util.List;

public interface AddressService {
    public void CreateAddress(AddressEntity address);
    public AddressEntity LoadAddressEntityByID(Long id);
    public List<AddressEntity> getAllAddress();
    public AddressEntity getAddressByIdCityName(String cityName);

}