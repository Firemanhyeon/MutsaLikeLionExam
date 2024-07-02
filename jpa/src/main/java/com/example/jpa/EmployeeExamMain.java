package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeExamMain {

    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Project project = em.find(Project.class,1L);
            log.info("진행중인 프로젝트 이름: "+project.getName());
            em.getTransaction().commit();

            for(Employee employee : project.getEmployees()){
                log.info("이 프로젝트에 참가중인 사원: "+employee.getName());
            }
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            //사원과 프로젝트 각각 생성
            Employee employee = new Employee();
            employee.setName("hihi");
            Project project = new Project();
            project.setName("lion project");
            //사원객체에서 프로젝트의 정보 추가 , 프로젝트 객체에서 사원의정보 추가
            employee.getProjects().add(project);
            project.getEmployees().add(employee);
            //영속성컨텍스트로 전환
            em.persist(employee);
            em.persist(project);

            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class,3L);
            employee.setName("changename");

            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class,4L);
            em.remove(employee);
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    private static void deleteExam(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class,1L);
            Project project = em.find(Project.class,2L);
            employee.getProjects().remove(project);
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        deleteExam();
    }
}
