package com.example.springphonebook;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    @Value("classpath:resource.txt")
    private Resource resource;

    public InputStream getInputStream() {
        return resource.getInputStream();
    }
}
