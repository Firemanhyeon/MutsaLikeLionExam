package org.blog.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authonizeRequest -> authonizeRequest
                        .requestMatchers("/shop/**" , "/test" , "/user/**").permitAll()//지정한 페이지 아무나 들어올수있게 하기
                        .requestMatchers("/user/mypage").hasRole("USER")//user권한을 가진 사람만 들어갈수있게
                        .requestMatchers("/admin/abc").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN","SUPERUSER")
                        .anyRequest()//모든요청에 대해
                        .authenticated()//인증을 요구하겠다
                )
                .formLogin(Customizer.withDefaults());


        return http.build();
    }
    //비밀번호 암호화해서 넣기
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //인가 관련 설정
    @Bean
    public UserDetailsService userDetailsService(){
        //실제 프로젝트에서는 이부분을 DB에 있는 사용자 정보를 이용할 수 있도록 코드를 만든다.

        UserDetails user = User.withUsername("user")//권한이 USER인 아이디 생성
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")//권한이 ADMIN인 아이디 생성
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails superuser = User.withUsername("superuser")//권한이 슈퍼유저인 아이디 생성
                .password(passwordEncoder().encode("1234"))
                .roles("SUPERUSER")
                .build();

        UserDetails carami = User.withUsername("carami")//권한이 어드민 , 유저 복수로 가능
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN" , "USER")
                .build();
        return new InMemoryUserDetailsManager(user , admin,superuser , carami);//인메모리방식으로 유저를 만들거다
    }
}
