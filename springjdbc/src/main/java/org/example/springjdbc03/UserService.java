package org.example.springjdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

    public void executeComplexBusinessProcess(String name , String email){
        transactionTemplate.execute(status -> {
           jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
           if(email.contains("error")){
               status.setRollbackOnly();//에러났을 시 롤백을 직접해준다
               System.out.println("rollback");
               throw new RuntimeException("error");
           }
           jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", "update.email.com", name);
            System.out.println(111111111);
           return null;
        });
    }

}
