package org.blog.realprojectexam.config;

import lombok.RequiredArgsConstructor;
import org.blog.realprojectexam.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/userregform" , "/userreg","/").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/loginform")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout(logout-> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                )
                //다른브라우저에서 여러개 접속해도 허용할지안할지 갯수정해주기
                .sessionManagement(sessionManagement->sessionManagement
                        .maximumSessions(1)//동시 접속 허용 개수
                        .maxSessionsPreventsLogin(true)//동시 로그인을 차단한다 default = false (먼저 로그인한 사용자를 차단한다)
                        //true - 애초에 허용개수를 초과하는 사용자는 로그인이 안되도록 차단.
                )
                .csrf(csrf-> csrf.disable())
                .userDetailsService(customUserDetailsService);

        return http.build();
    }
    //비밀번호 암호화해서 넣기
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
