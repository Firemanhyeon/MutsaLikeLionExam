package com.example.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private JPAUtil(){} //private한 디폴트생성자를 만들어줌으로써 외부에서 함부로 선언못하게한다.

    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("UserPU"); //필드 선언

    public static EntityManagerFactory getEntityManagerFactory(){ //외부에서 쓰긴해야되니까 공장을 리턴하는 메소드 생성
        return emfInstance;
    }

    //어플리케이션이 종료될 때 자동으로 close()메소드가 호출하도록 구현
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            if(emfInstance != null){
                System.out.println("----------------emf close");
                emfInstance.close();
            }
        }));
    }
}
