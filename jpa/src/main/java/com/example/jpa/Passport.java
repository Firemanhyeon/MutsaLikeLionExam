package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_number")
    private String passPortNumber;

    @OneToOne(mappedBy = "passport" ,cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "person_id" ,unique = true)
    private Person person;

    public Passport(String passPortNumber) {
        this.passPortNumber = passPortNumber;
    }
}
