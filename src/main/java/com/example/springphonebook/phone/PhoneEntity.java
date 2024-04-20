package com.example.springphonebook.phone;

import com.example.springphonebook.BaseEntity;
import com.example.springphonebook.person.PersonEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity extends BaseEntity<Long>{
    private String phoneNumber;
    private String phoneType;




}
