package org.blog.jwtexam;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.blog.jwtexam.jwt.util.JwtTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class JwtexamApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtexamApplication.class,args);
    }

    @Autowired
    JwtTokenizer jwtTokenizer;


//    @Bean
//    public CommandLineRunner run(){
//        return args -> {
//            String accessToken =  jwtTokenizer.createAccessToken(
//                    1L,"test@test.com","test", "testuser", Arrays.asList("ROLE_USER")
//            );
//
//            log.info("AccessToken {}",accessToken);
//
//            String refreshToken = jwtTokenizer.createRefreshToken(
//                    1L,"test@test.com","test", "testuser", Arrays.asList("ROLE_USER")
//            );
//
//            log.info("RefreshToken {}" , refreshToken);
//
////            Long id = jwtTokenizer.getUserIdFromToken(accessToken);
////            log.info("id: {}",id);
//
//            Claims claims =  jwtTokenizer.parseAccessToken(accessToken);
//            log.info("Access Token accesstoken {}" , claims);
//            log.info("userId: {}" , claims.get("userId"));
//
//            Claims refreshToken1 =  jwtTokenizer.parseRefreshToken(refreshToken);
//            log.info("Access Token refreshToken1 {}" , refreshToken1);
//
//        };
//
//    }
}