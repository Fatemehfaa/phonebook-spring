package com.example.springphonebook.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
/*    @Query("select per from PersonEntity per where per.nationalCode = ?1 ")
    Optional<PersonEntity> findByNationalCode(String nationalCode);*/
    public PersonEntity getPersonEntityByNationalCode(String nationalCode);
    public List<PersonEntity> getPersonEntityByFirstname(String firstName);
}
