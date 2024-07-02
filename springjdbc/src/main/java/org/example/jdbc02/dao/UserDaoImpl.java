package org.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.example.jdbc02.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;
@RequiredArgsConstructor//롬복에서 제공하는 애노테이션. final이 붙은 필드만 생성자를 주입한다.(생성자를 기본으로 생성해준다)
@Repository
public class UserDaoImpl implements UserDao{
    //필드기반으로 의존성주입
    private final JdbcTemplate jdbcTemplate;

    //생성자기반으로 의존성주입
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
    //Setter기반으로 의존성주입



    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name,email) values(?,?)";
        try{
            jdbcTemplate.update(sql,user.getName(),user.getEmail());

        }catch(DataAccessException e){
            throw new DataAccessException("사용자를 입력하다 오류발생"+user.getName(),e){};
        }
    }

    @Override
    public List<User> findAllUsers() {
        RowMapper<User> rowMapper = (ResultSet rs , int rowNum)-> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")

        );
        List<User> users = jdbcTemplate.query("select * from users",rowMapper);
        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email = ? WHERE name = ?";
        int cnt = jdbcTemplate.update(sql,email,name);
        if(cnt==0){
            throw new UserNotFoundException("수정할 이름의 정보가 없습니다.");
        }
    }

    @Override
    public void deleteUser(String name) {
        String sql="DELETE FROM users WHERE name = ?";
        int cnt = jdbcTemplate.update(sql,name);
        if(cnt==0){
            throw new UserNotFoundException("삭제할 이름의 정보가 없습니다.");
        }
    }
}
