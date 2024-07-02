package org.example.springjdbc06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public class UserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private Properties sqlQueries;

    public void insertUser(User user) {
        String sql =sqlQueries.getProperty("INSERT_USER");//queries.sql에서 선언한 key값을 넣어주면 그 구문이 return 되어 온다.
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName());//queries.sql에서 선언한 이름이랑 같아야함.
        params.addValue("email", user.getEmail());
        jdbcTemplate.update(sql,params);
    }
}
