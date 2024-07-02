package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookExamMain {
    public static void select(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Book book = em.find(Book.class,1L);
            log.info(book.getTitle());
            Author author = em.find(Author.class , 1L);
            log.info(author.getName());
            for(Book book1 : author.getBooks()){
                log.info(book1.getTitle());
            }
        }finally {
            em.close();
        }
    }
    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = new Author("hihihi");
            Book book = new Book("book1" , author);
            Book book2 = new Book("book2" , author);
            Book book3 = new Book("book3" , author);
            Book book4 = new Book("book4" , author);
            author.getBooks().add(book);
            author.getBooks().add(book2);
            author.getBooks().add(book3);
            author.getBooks().add(book4);
            em.persist(author);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class,3L);
            author.setName("ehllo");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class,3L);
            em.remove(author);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        delete();
    }
}
