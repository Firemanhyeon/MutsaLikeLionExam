package org.example.springdatajdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }
    @Bean
    CommandLineRunner demo(UserRepository  userRepository) {
        return args -> {
//            userRepository.save(new User("ccz", "asdf@123"));
//            List<User> list = (List<User>) userRepository.findAll();
//            list.forEach(System.out::println);
//
//            User user = userRepository.findById(25L).get();
//            System.out.println(user.getName());

            User user1 = userRepository.findByName("john");
            System.out.println(user1.getName());
            System.out.println(user1.getId());
            System.out.println(user1.getEmail());
//            PageRequest pageRequest = PageRequest.of(1, 5);
//            Page<User> allUsersWithPagination = userRepository.findAllUsersWithPagination(pageRequest);
//            allUsersWithPagination.forEach(usera -> System.out.println("name: "+usera.getName()+" "+"email: "+usera.getEmail()));
        };
    }

//    @Bean
//    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate){
//        return args -> {
//            List<User> users = Arrays.asList(
//                    new User(null, "Alice", "alice@example.com"),
//                    new User(null, "Bob", "bob@example.com"),
//                    new User(null, "Charlie", "charlie@example.com"),
//                    new User(null, "David", "david@example.com")
//            );
//
//            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
//
//            int[] updateCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//                public void setValues(PreparedStatement ps, int i) throws  SQLException {
//                    User user = users.get(i);
//                    ps.setString(1,user.getName());
//                    ps.setString(2,user.getEmail());
//                }
//                public int getBatchSize() {
//                    return users.size();
//                }
//            });
//        };
//    }
}
