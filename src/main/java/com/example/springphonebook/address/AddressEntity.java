package com.example.springphonebook.address;

import com.example.springphonebook.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity<Long> {
    private String street;
    private String CityName;
    private int plaque;

}
