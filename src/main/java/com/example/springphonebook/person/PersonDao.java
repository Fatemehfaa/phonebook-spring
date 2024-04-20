package com.example.springphonebook.person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;



    public List<PersonEntity> test(Long id){
        List<PersonEntity> result =  entityManager.createQuery("select per from PersonEntity per where per.id =: personId", PersonEntity.class )
                .setParameter("personId" , id)
                .getResultList();
        return result;

    }
}
