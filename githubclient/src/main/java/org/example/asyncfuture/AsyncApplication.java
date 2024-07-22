package org.example.asyncfuture;

import org.example.asyncfuture.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class AsyncApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class,args);
    }
    @Autowired
    private AsyncService asyncService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("async메소드 호출");
        Future<String> result1 = asyncService.asyncMethod1();
        Future<String> result2 = asyncService.asyncMethod1();
        Future<String> result3 = asyncService.asyncMethod1();

        System.out.println("다른작업");
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result1.get());

    }
}
