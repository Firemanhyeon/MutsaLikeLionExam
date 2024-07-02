package org.example.springjdbc03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);

    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService){
        return args -> {
            try{
                userService.executeComplexBusinessProcess("eee" , "error@error");
                userService.executeComplexBusinessProcess("error1" , "error");

            }catch (RuntimeException e){
                System.out.println(e.getMessage()+"111111111");
            }
        };
    }
}
