package org.blog.eventexam.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync
public class Eventexam2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Eventexam2Application.class, args);
    }

    @Autowired
    private CustomEventPublisher customEventPublisher;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("test");
        System.out.println("applicationEvnet ThreadName" +Thread.currentThread().getName());
        customEventPublisher.publisherEvent("hello");
    }
}
