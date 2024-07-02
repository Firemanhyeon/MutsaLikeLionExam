package org.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepository1Test {
    @Autowired
    private UserRepository repository;

    @Test
    void save(){
        User user = new User("test1" , "test.com");
        repository.save(user);
        System.out.println(user.getId());
    }

    @Test
    void findByName(){
        List<User> users = repository.findByName("test1");
        assertThat(users.size()).isEqualTo(4);
    }

    @Test
    void findByEmail(){
        List<User> users = repository.findByEmail("123@123");
        users.forEach(user-> System.out.println(user.getId()));
        assertThat(users.size()).isEqualTo(12);
    }

    @Test
    void modifyEmail(){
        repository.updateUserEmail(1L,"zxc@zxc");
        Optional<User> user = repository.findById(1L);
        assertThat((user.get().getEmail())).isEqualTo("zxc@zxc");
    }

    @Test
    void deleteById(){
        int a = repository.delete1ById(1L);
        System.out.println(a);
        Optional<User> user = repository.findById(1L);
        assertThat(user.get().getId()).isEqualTo(1L);
    }

}