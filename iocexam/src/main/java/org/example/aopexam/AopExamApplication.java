package org.example.aopexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopExamApplication implements CommandLineRunner {
    @Autowired
    SimpleService service;

    public static void main(String[] args) {
        SpringApplication.run(AopExamApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("runtest");
        System.out.println(service.doSomething());

        //실행결과 : run 메소드가 실행되기전에 먼저 before aspect가 실행되고 runtest출력 , service.doSimthing()호출하면 doSomethig메소드 호출하기전에 aspect 실행. 그 이후에 dosomething 메소드 출력
        //service.hello();

        service.setName("hhhh");


    }



}
