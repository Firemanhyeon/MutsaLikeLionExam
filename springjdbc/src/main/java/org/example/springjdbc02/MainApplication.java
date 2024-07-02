package org.example.springjdbc02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner(UserDao userDao){
        return args -> {
            try{
                userDao.createAndUpdateUser("hohyeon","123@123","aaaa@111");
                System.out.println(1111111);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        };
    }
}
