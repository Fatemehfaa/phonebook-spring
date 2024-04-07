package com.example.springphonebook.phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity,Long> {
    @Query("select phone from PhoneEntity phone where phone.id =: phoneId")
    PhoneEntity findPhoneEntityById(@Param("id")Long phoneId);

    PhoneEntity findByPhoneType(String phoneType);
}
