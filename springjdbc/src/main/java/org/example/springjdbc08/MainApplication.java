package org.example.springjdbc08;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserDao userDao){
        return args -> {
            User user = new User();
            user.setName("myuser1");
            user.setEmail("myEmail1@gmail.com");
            User reuslt = userDao.insertUser(user);
            System.out.println(reuslt.getId());
        };
    }
}
