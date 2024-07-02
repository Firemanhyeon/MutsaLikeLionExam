package org.example.springdatajpa.springdatajpa2;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajpa.User;
import org.example.springdatajpa.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner run(UserRepository repository){
        return args -> {
            //create
//            User user = new User("kangvvv" , "123@123");
//            repository.save(user);
//            log.info("사용자 추가: "+user.getName());
//          //delete
//            repository.deleteById(user.getId());
            //select by name
            List<User> users = repository.findByName("test1");
            users.forEach(user-> log.info(user.getName()+"::"+user.getEmail()));
        };
    }
}
