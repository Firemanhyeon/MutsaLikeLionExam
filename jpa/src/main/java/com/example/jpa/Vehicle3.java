package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//테이블당 구체클래스전략 사용하겠다
@Table(name = "Vehicle3")
@Getter@Setter
public abstract class Vehicle3 {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) //TABLE 전략은 별도의 데이터베이스 테이블을 사용하여 기본 키 값을 생성하는 방식입니다. 이 테이블을 키 생성 테이블이라고 하며, 각 엔티티에 대해 고유한 키 값을 보장합니다. 시퀀스를 위한 테이블을 새로 만들어 그 시퀀스를 이용하여 조회 등 작업을 한다.
                                                    //Identity를 써버리게되면 Car객체도 1번부터 줄거고 Truck객체도 1번부터 줄거기 때문에 Vehicle에선 1번이 겹치게되버린다. 그래서 각각의 시퀀스를 생성한다. (이 시퀀스는 번호만 부여하는 테이블) 누군가가 시퀀스를 달라하면 주고 다음번호로 업데이트 후 가지고있는다.
                                                    // 가지고있다가 또 달라하면 주고 다음걸로 수정한다 = (값이 겹칠일이 없다)
    private Long id;
    private String manufacturer;
}
//테이블 당 구체클래스 전략

@Entity
@Getter@Setter
class Car3 extends Vehicle3{
    private int seatCount;
}

@Entity
@Getter@Setter
class Truck3 extends Vehicle3{
    private double payloadCapacity;
}
