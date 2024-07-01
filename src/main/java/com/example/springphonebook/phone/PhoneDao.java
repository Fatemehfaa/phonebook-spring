package com.example.springphonebook.phone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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



    public List<PhoneEntity> testCriteria(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PhoneEntity> criteriaQuery = criteriaBuilder.createQuery(PhoneEntity.class);
        Root<PhoneEntity> root = criteriaQuery.from(PhoneEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        List<PhoneEntity> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;

//        Sorting
//        criteriaQuery.orderBy(
//                criteriaQuery.asc(root.get("phoneNumber")),
//                criteriaQuery.desc(root.get("phoneType")));

//        Deleting
//        CriteriaDelete<PhoneEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(PhoneEntity.class);
//        Root<PhoneEntity> root = criteriaDelete.from(PhoneEntity.class);
//        criteriaDelete.where(criteriaBuilder.greaterThan(root.get("phoneNumber"), target));

    }


}
