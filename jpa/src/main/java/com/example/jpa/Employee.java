package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable( //해당이름으로 조인테이블을 만든다
            name="employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),//기본키로
            inverseJoinColumns = @JoinColumn(name = "project_id")//반대쪽에 기본키로
    )
    private Set<Project> projects = new HashSet<>();
}
