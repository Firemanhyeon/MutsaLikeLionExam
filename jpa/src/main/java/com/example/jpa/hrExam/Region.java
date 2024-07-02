package com.example.jpa.hrExam;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "regions")
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_name")
    private String regionName;

    @OneToMany(mappedBy = "region" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Country> list = new ArrayList<>();

    public Region(String regionName) {
        this.regionName = regionName;
    }
}
