package com.example.springphonebook.phone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PhoneDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PhoneEntity> test(Long id) {
        List<PhoneEntity> resultList = entityManager.createQuery("select phone from PhoneEntity phone where phone.id =: phoneId", PhoneEntity.class)
                .setParameter("phoneId", id).getResultList();
        return resultList;
    }


}
