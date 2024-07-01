package com.example.springphonebook.person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
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

    //show all rows of PersonEntity
    public List<PersonEntity> criteriaTest(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> criteriaQuery = criteriaBuilder.createQuery(PersonEntity.class);
        Root<PersonEntity> root = criteriaQuery.from(PersonEntity.class);
        //To check if the given property is not null:
        //criteriaQuery.select(root).where(criteriaBuilder.isNotNull(root.get("nationalCode")));
        criteriaQuery.select(root);
        List<PersonEntity> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;
    }

}
