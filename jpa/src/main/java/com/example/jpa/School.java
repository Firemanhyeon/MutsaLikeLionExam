package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "school" ,cascade = CascadeType.ALL , orphanRemoval = true )//mappedBy : ~~를 참조하고있다 , cascade :  연관된 엔티티에 대해 모든 CRUD 작업을 전파하는 것을 의미
                                                                                // , orphanRemoval = true : 업뎃되거나 삭제되면 연관들도 같이삭제
    private List<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }
}
