package org.example.springjdbc04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.jdbc01.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
    @Bean
    CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
        return args -> {
          String sql = "select * from users";
            RowMapper<User> rowMapper = (ResultSet rs , int rowNum)-> new User(//로우매퍼타입으로 람다식이용하여 구현
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );
          List<User> users = jdbcTemplate.query(sql, rowMapper);
          users.forEach(user -> System.out.println(user));
        };
    }
//    private static class UserRowMapper implements RowMapper<User> {//클래스 선언하여 구현
//
//        @Override
//        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Long id = rs.getLong("id");
//            String name = rs.getString("name");
//            String email = rs.getString("email");
//
//            return new User(id, name, email);
//        }
//    }

    @Getter
    @AllArgsConstructor
    @ToString
    static class User{
        private Long id;
        private String name;
        private String email;

    }
}
