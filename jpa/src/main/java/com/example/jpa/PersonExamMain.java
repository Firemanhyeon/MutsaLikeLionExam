package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            Passport passport = em.find(Passport.class,4L);
            log.info(passport.getPerson().getName());
            Person person = em.find(Person.class,1L);
            log.info(person.getName());
            log.info(person.getPassport().getPassPortNumber());

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            Passport passport = new Passport("123");

            Person person = new Person();
            person.setName("aaa");
            passport.setPerson(person);
            person.setPassport(passport);
            em.persist(passport);
//            Person person = new Person();
//            person.setName("test1");
//            Passport passport = new Passport("123");
//            person.setPassport(passport);
//            passport.setPerson(person);
//            em.persist(person);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = em.find(Person.class,1L);
            Passport passport = em.find(Passport.class,person.getPassport().getId());
            passport.setPassPortNumber("123123121111");
            person.setPassport(passport);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
            //패스포트만 삭제
            Passport passport = em.find(Passport.class,5L);
            if(passport!=null){
                passport.getPerson().setPassport(null);
            }
            em.remove(passport);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        create();
    }
}
