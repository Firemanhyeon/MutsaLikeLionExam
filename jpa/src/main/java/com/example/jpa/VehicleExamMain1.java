package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleExamMain1 {
    public static void create(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        Car car1 = new Car();
        car1.setManufacturer("Toyota");
        car1.setSeatCount(5);
        entityManager.persist(car1);

        Car car2 = new Car();
        car2.setManufacturer("hyundai");
        car2.setSeatCount(4);
        entityManager.persist(car2);

        Truck truck = new Truck();
        truck.setManufacturer("kia");
        truck.setPayloadCapacity(10.0);
        entityManager.persist(truck);

        entityManager.getTransaction().commit();
    }
    public static void select(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

//        Car car3 = entityManager.find(Car.class,1L);//차에 해당하는 한개의 차 출력
//        log.info(car3.getManufacturer());

        //차 전부가져오기
        List<Vehicle> list = entityManager.createQuery("select v from Vehicle v" , Vehicle.class).getResultList(); // from절에 테이블명을 적는게아니라 앤티티명을 가져온다.
        for(Vehicle vehicle : list){
            if(vehicle instanceof Car){//Vehicle클래스에선 Car에 있는 정보들을 쓰지 못하니 강제형변환 진행해서 가져오기
                Car car = (Car)vehicle;
                log.info("carInfo: {},{}",car.getManufacturer(),car.getSeatCount());
            }else if(vehicle instanceof Truck){
                Truck truck = (Truck) vehicle;
                log.info(truck.getManufacturer());
                log.info(String.valueOf(truck.getPayloadCapacity()));
            }
        }

        entityManager.getTransaction().commit();
    }
    public static void main(String[] args) {
        select();
    }
}
