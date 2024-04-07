package com.example.springphonebook.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    public AddressEntity getAddressEntityByCityName (String cityName);

}
