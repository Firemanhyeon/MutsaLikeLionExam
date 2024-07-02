package org.blog.securityexam;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authonizeRequest -> authonizeRequest
                        .anyRequest()//모든요청에 대해
                        .authenticated()
                );//인증을 요구하겠다
        //로그인설정
        http
                .formLogin(formlogin-> formlogin//폼로그인방식으로(기본적으로 제공되는 로그인창으로 = defualt~~)
                        //.loginPage("/loginForm")//로그인페이지 경로
                        .defaultSuccessUrl("/success")//성공했을때 요청할 경로
                        .failureUrl("/fail")//실패했을때 요청할경로
                        .successHandler((request, response, authentication) -> {
                            log.info("로그인성공"+authentication.getName());
                            response.sendRedirect("/success");
                        })//성공했을때 처리
                        .failureHandler((request, response, exception) -> {
                            log.info("exception"+exception.getMessage());
                            response.sendRedirect("/loginForm");
                        })
                        .usernameParameter("userId")//name속성 userId로 변경
                        .passwordParameter("passwd")//name속성 passwd로 변경
                        .loginProcessingUrl("/login_p")//로그인로직 요청 url변경
                        .permitAll());//loginpage에 대한 요청은 누구나 요청할 수 있도록
        //로그아웃설정
        http
                .logout(logout-> logout
                        //.logoutUrl("/log_out")//로그아웃url설정
                        .logoutSuccessUrl("/loginForm")//로그아웃성공시 다음url요청
                        .addLogoutHandler((request, response, authentication) -> {
                            log.info("addLogoutHandler");
                            HttpSession session = request.getSession();//세션가져오기
                            session.invalidate();//세션무효화
                        })
                        .logoutSuccessHandler((request, response, authentication) -> {
                            log.info("logout:SuccessHandler");
                            response.sendRedirect("/loginForm");//로그아웃성공 시 로그인페이지로이동
                        })
                        .deleteCookies("remember-me")
                );

        return http.build();
    }
}
