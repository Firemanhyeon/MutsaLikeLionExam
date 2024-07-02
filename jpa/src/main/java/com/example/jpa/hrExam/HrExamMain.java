package com.example.jpa.hrExam;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HrExamMain {
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Region region = em.find(Region.class,5);
            for(Country country : region.getList()){
                log.info(country.getCountryName());
            }
            log.info(region.getRegionName());

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Region region = new Region("테스트1");
            Country country1= new Country("80","country1",region);
            Country country2= new Country("81","country2",region);
            Country country3= new Country("82","country3",region);
            Country country4= new Country("83","country4",region);


            em.persist(region);
            em.persist(country1);
            em.persist(country2);
            em.persist(country3);
            em.persist(country4);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Region region = em.find(Region.class,5);

            Country country = em.find(Country.class, 80);
            country.setCountryName("123123");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Region region = em.find(Region.class,5);
            em.remove(region);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        delete();

    }
}
