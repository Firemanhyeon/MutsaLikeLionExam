package org.example.springjdbc06;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserDao userDao) {
        return args -> {
                User user = new User(null, "zzzzz", "Doe");
                userDao.insertUser(user);

        };
    }
}
