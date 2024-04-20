package com.example.springphonebook.phone;

import java.util.List;

public interface PhoneService {

    public void createPhone(PhoneEntity phone);
    public PhoneEntity getPhoneById(Long id);
    public List<PhoneEntity> getAllPhone();
    public PhoneEntity getPhoneByPhoneNumber(String phoneNumber);
    List<PhoneEntity> showPhone();

}
