package com.example.springphonebook.person;

import com.example.springphonebook.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends BaseEntity<Long> {

    private String firstname;
    private String surname;
    private String nationalCode;

}
