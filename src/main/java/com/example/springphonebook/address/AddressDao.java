package com.example.springphonebook.address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Transaction;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
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

    public List<AddressEntity> testCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AddressEntity> criteriaQuery = criteriaBuilder.createQuery(AddressEntity.class);
        Root<AddressEntity> root = criteriaQuery.from(AddressEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), "addressId"));
        List<AddressEntity> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;

        //In order to get items having a plaque of more than 100:
        //criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("plaque"),100));

        //getting items having plaque less than 100:
        //criteriaQuery.select(root).where(criteriaBuilder.lt(root.get("plaque"),100));
    }

    public List<AddressEntity> addressEntities() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate <AddressEntity> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(AddressEntity.class);
        Root<AddressEntity> root = criteriaUpdate.from(AddressEntity.class);
        criteriaUpdate.set("cityName", "tabriz");
        criteriaUpdate.where(criteriaBuilder.equal(root.get("cityName"), "oldCity"));
        return (List<AddressEntity>) entityManager.createQuery(criteriaUpdate).getResultList();
/*
        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaUpdate).executeUpdate();
        transaction.commit();
*/
    }



}



