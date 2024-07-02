package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleExamMain2 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
//        Car2 car1 = new Car2();
//        car1.setManufacturer("Toyota");
//        car1.setSeatCount(5);
//        em.persist(car1);
//
//        Car2 car2 = new Car2();
//        car2.setManufacturer("HYUNDAI");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck2 truck1 = new Truck2();
//        truck1.setManufacturer("KIA");
//        truck1.setPayloadCapacity(20.0);
//        em.persist(truck1);
//
//        Truck2 truck2 = new Truck2();
//        truck2.setManufacturer("VOLVO");
//        truck2.setPayloadCapacity(15.5);
//        em.persist(truck2);

        //차 전부가져오기
        List<Vehicle2> list = em.createQuery("select v from Vehicle2 v" , Vehicle2.class).getResultList(); // from절에 테이블명을 적는게아니라 앤티티명을 가져온다.
        for(Vehicle2 vehicle : list){
            if(vehicle instanceof Car2){//Vehicle클래스에선 Car에 있는 정보들을 쓰지 못하니 강제형변환 진행해서 가져오기
                Car2 car = (Car2)vehicle;
                log.info("carInfo: {},{}",car.getManufacturer(),car.getSeatCount());
            }else if(vehicle instanceof Truck2){
                Truck2 truck = (Truck2) vehicle;
                log.info(truck.getManufacturer());
                log.info(String.valueOf(truck.getPayloadCapacity()));
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}