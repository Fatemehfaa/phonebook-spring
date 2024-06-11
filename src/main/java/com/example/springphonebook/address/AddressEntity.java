package com.example.springphonebook.address;

import com.example.springphonebook.BaseEntity;
import com.example.springphonebook.person.PersonEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity extends BaseEntity<Long> {
    private String street;
    private String cityName;
    private int plaque;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;


//    @UpdateTimestamp
//    private LocalDateTime lastUpdate;
//    @CreationTimestamp
//    private LocalDateTime createDate;

}
