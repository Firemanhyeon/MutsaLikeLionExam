package org.example.completablefuture;

import org.example.completablefuture.service.AsyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class CompletableApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompletableApplication.class,args);
    }

    @Bean
    public CommandLineRunner run(AsyncService asyncService){
        return args -> {
            System.out.println("async메소드 호출");
            CompletableFuture<String> result1 = asyncService.asyncMethod1();
            CompletableFuture<String> result2 = asyncService.asyncMethod1();
            CompletableFuture<String> result3 = asyncService.asyncMethod1();
            System.out.println("다른작업 수행");

            //future객체보다 조금 더 정교하게 사용할 수 있다.

            //비동기 메소드 결과를 조합

            CompletableFuture.allOf(result1,result2).thenRun(()->{
               System.out.println(result1.join());
            });

        };
    }
}
