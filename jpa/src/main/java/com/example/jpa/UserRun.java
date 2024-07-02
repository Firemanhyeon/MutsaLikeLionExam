package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //엔티티 생성 -- 아직은 영속성 컨텍스트가 관리하지 않는 상태
//        User user = new User();
//        //user.setId(1L);
//        user.setName("carami3333");
//        user.setEmail("33333@asdf.com");
//        //여기까지도 영속성 컨텍스트가 관리하지않음


//
//        entityManager.persist(user);//영속성 컨텍스트한테 관리를 맡긴 상태
//
//        entityManager.getTransaction().commit();//이때 db에 저장.

        //원래 두개의 객체는 다르다고 판단해야하는데 영속성 컨텍스트의 특성(영속성 컨텍스트의 스냅샷) 때문에 같다고 나온다.
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();//트랜잭션 시작entityManager
//        User findUser = entityManager.find(User.class , 1L);
//        User findUser2 = entityManager.find(User.class , 1L);
//        if(findUser==findUser2){
//            log.info("11111");
//        }else{
//            log.info("2222");
//        }

        //update 예제
//        User user1 =  entityManager.find(User.class,1L);
//        user1.setEmail("1222222수정@naa.com");
//
//        user1.setName("hhhhhhhhh");
//        //이때 DB에 저장함
//        entityManager.getTransaction().commit();

        //delete 예제
        User user1 = entityManager.find(User.class,1L);
        entityManager.remove(entityManager.contains(user1) ? user1 :entityManager.merge(user1));

        entityManager.getTransaction().commit();
    }
}
