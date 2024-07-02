package org.example.javaspringmvc.friend.dao;

import lombok.RequiredArgsConstructor;
import org.example.javaspringmvc.friend.dto.Friend;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class FriendDAOImpl implements FriendDAO{
    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Friend> selectFriendList() {
        RowMapper<Friend> rowMapper = (ResultSet rs , int rowNum) -> new Friend(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
        List<Friend> friends = jdbcTemplate.query("select * from Friend",rowMapper);
        System.out.println(friends);
        return friends;
    }
}
