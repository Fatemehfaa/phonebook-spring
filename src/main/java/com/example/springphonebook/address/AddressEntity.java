package com.example.springphonebook.address;

import com.example.springphonebook.BaseEntity;
import com.example.springphonebook.person.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity<Long> {
    private String street;
    private String cityName;
    private int plaque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private PersonEntity person;


//    @UpdateTimestamp
//    private LocalDateTime lastUpdate;
//    @CreationTimestamp
//    private LocalDateTime createDate;

}
