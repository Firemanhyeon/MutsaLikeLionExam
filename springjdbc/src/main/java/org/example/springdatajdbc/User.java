package org.example.springdatajdbc;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
//엔티티  DTO는 단순히 값만 담아서 전달되는 객체라면 엔티티는 데이터베이스와의 관계를 알려주는 역할도 한다.
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table("users")//테이블명이랑 클래스명이랑 다르면 괄호안에 명시해줘야한다.
@AllArgsConstructor
public class User {
    @Id//id라고 명시해줘야함.약속
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
