package org.example.springdatajdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor//final인 필드만 생성자 만든다.
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Page<User> findAllUsersWithPagination(Pageable pageable) {
        String countQuery = """
                SELECT COUNT(*)
                FROM users
                """;//전체 사용자의 숫자 구하기
        String query = "SELECT id, name , email FROM users LIMIT :limit OFFSET :offset";
        Map<String,Object> params = new HashMap<>();
        params.put("limit" , pageable.getPageSize());//메인에서 직접 입력한 현재페이지에 나올 갯수
        params.put("offset" , pageable.getOffset());//메인에서 직접 입력한 현재페이지

        List<User> users = jdbcTemplate.query(query , params , new BeanPropertyRowMapper<>(User.class));
                                            //쿼리실행 , limit , offset  들어간 map , User클래스랑 DB이름같으니 BeanPropertyRowMapper)

        return PageableExecutionUtils.getPage(users,pageable,
                ()-> jdbcTemplate.queryForObject(countQuery , params , Long.class));
    }
}
