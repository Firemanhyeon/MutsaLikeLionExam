package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//싱글테이블 전략을 사용하겠다.
@DiscriminatorColumn(name = "type" , discriminatorType = DiscriminatorType.STRING) //필드명 : 타입 , 구분할 타입 (타입이라는 컬럼이 생성된다. 구분할수있는 역할이고 그 타입은 string이다 )
@Getter@Setter
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}
//단일테이블전략

@Entity
@DiscriminatorValue("CAR")//Car라는 단어로 구분할래
@Getter@Setter
 class Car extends Vehicle{
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")//TRUCK이라는 단어로 구분할래
@Getter@Setter
 class Truck extends Vehicle{
    private double payloadCapacity;
}
