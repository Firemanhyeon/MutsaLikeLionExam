package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);

    }

    //간편하게 실행시켜보는 클래스 CommandLineRunner
    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            //create
            jdbcTemplate.update("INSERT INTO users(name , email) VALUES (?,?)","kim1","kim2@gmail.com");
            String sql = "INSERT INTO users(name , email) VALUES (?,?)";
            jdbcTemplate.update(sql,"hong","hong@gmail.com");

            //read
            //RowMapper 를 이용해야하는 이유는 결과값 담을때 테이블의 컬럼과 User Class의 필드를 매칭시켜줘야 하기 때문
            //만약 테이블의 컬럼과 클래스의 필드가 완전히 일치하다면 RowMapper를 쓸 필요도 없다. (BeanPropertyRowMapper)사용한다.
            List<User> list = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(User.class));
            for (User user : list) {
                System.out.println(user.getName()+"의 이메일은"+user.getEmail());
            }
            list.forEach(System.out::println);

            RowMapper<User> rowMapper = (ResultSet rs , int rowNum)-> new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );

            List<User> users = jdbcTemplate.query("SELECT * FROM users", rowMapper);
            users.forEach(user -> System.out.println(user.getName()+"-"+user.getEmail()));

            jdbcTemplate.update("UPDATE users SET email=? where name=?","new.kim1@example.com","kim1");
        };
    }
}
