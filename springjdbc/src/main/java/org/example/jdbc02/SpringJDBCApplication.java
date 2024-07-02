package org.example.jdbc02;

import org.example.jdbc02.dao.User;
import org.example.jdbc02.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);

    }
    @Bean
    public CommandLineRunner demo(UserDao userDao, JdbcTemplate jdbcTemplate){
        return args -> {
            //삽입
            //userDao.insertUser(new User(null,"jeong","hong@exam.com"));
            //조회
            List<User> list = userDao.findAllUsers();
            list.forEach(System.out::println);

            //수정
            userDao.updateUserEmail("aaa","123@123.com");
            //삭제
            userDao.deleteUser("hihi");
        };
    }
}
