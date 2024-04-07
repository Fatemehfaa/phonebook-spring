package com.example.springphonebook.phone;

import com.example.springphonebook.Validation;
import com.example.springphonebook.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class phoneServiceImpl implements PhoneService {
    private PhoneRepository phoneRepository;
    @Autowired
    public phoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void createPhone(PhoneEntity phone) {
        boolean b = Validation.validateMobilNumber(phone.getPhoneNumber());
        if (!b)
            throw new RuntimeException("phoneNumber not valid.");
        else
            this.phoneRepository.save(phone);
    }

    @Override
    public PhoneEntity getPhoneById(Long id) {
        Optional<PhoneEntity> result = phoneRepository.findById(id);
        PhoneEntity phone ;
        if(result.isPresent()){
            phone = result.get();
        }else {
            phone = null;
        }
        return phone;
    }

    @Override
    public List<PhoneEntity> getAllPhone() {
        List<PhoneEntity> all = phoneRepository.findAll();
        if(all.isEmpty())
            throw new RuntimeException("phone not found.");
        else
            return all;
    }

    @Override
    public PhoneEntity getPhoneByPhoneNumber(String phoneNumber) {
        PhoneEntity byPhoneNumber = phoneRepository.findByPhoneNumber(phoneNumber);
        if(byPhoneNumber==null)
            throw new RuntimeException("phoneNumber not found.");
        return byPhoneNumber;
    }
}
