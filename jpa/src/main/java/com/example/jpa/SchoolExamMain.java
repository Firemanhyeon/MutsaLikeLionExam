package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
    //select
    public static void select(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = em.find(School.class , 1L);
            log.info(school.getName());
            log.info("--------------");
            for(Student stu : school.getStudents()){
                log.info(stu.getName());
            }

            Student student = em.find(Student.class,1L);
            log.info("student name : {}" , student.getName());
            log.info("student school: {}" , student.getSchool().getName());
            //em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    //create
    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = new School("Lion School"); //스쿨객체만들고
            Student student1 = new Student("강경미" , school); //그스쿨에 해당하는 학생객체만든다
            Student student2 = new Student("이나연" , school);
            Student student3 = new Student("한승균" , school);
            school.getStudents().add(student1); // schools 객체의 student List에 add 하기
            school.getStudents().add(student2);
            school.getStudents().add(student3);
            em.persist(school); //영속성상태로 전환

            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }
    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            //스쿨객체 얻어오기
            School school = em.find(School.class , 4L);
            school.setName("Like School");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = em.find(School.class , 5L);
            em.remove(school);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        delete();

    }
}
