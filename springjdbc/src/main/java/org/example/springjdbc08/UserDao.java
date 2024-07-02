package org.example.springjdbc08;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    //입력이 되면 자동으로 생성된 pk값을 리턴받아야한다.
    //SimpleJdbcInsert
    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");//직접 insert구문을 적지않기때문에 테이블이름을 알려줘야함 , 가져올값도 명시해줘야함.
    }

    public User insertUser(User user) {
        Map<String,Object> params = new HashMap<>();
        params.put("name", user.getName());//컬럼명 , 넣을값
        params.put("email", user.getEmail());//컬럼명 , 넣을값
        Number pk = simpleJdbcInsert.executeAndReturnKey(params);//executeAndReturnKey메소드는 넣어줄 컬럼을 map형태로 받기로 되어있기때문에 map타입으로 보내줘야함.
        user.setId(pk.longValue());
        return user;
    }
}
