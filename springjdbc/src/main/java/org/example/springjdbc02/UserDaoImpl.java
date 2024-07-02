package org.example.springjdbc02;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createAndUpdateUser(String name, String email, String newEmail) {
        try{
            jdbcTemplate.update("INSERT INTO users(name , email) VALUES (?, ?)", name, email);//insert가 되었다
            if(newEmail.contains("error")){
                throw new RuntimeException("simulated error");//에러가 났을때 exception 발생시켰다.
            }
        }catch (Exception e){
            jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", newEmail, name); // update문이 실행이 되지 않았으므로 insert도 Rollback되고있음.
        }
    }
}
