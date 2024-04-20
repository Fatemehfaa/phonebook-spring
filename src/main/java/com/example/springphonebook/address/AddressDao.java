package com.example.springphonebook.address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AddressDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<AddressEntity> test(){
        List <AddressEntity> result = entityManager.createQuery("select address from AddressEntity address where address.id = ?1" , AddressEntity.class)
                .setParameter(1, "addressId")
                .getResultList();
        return result;
    }

//    public AddressDao findById(Long id){
//        return entityManager.find(AddressDao.class,id);
//    }



}
