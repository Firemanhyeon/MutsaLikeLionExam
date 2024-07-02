package org.blog.jwtexam.config;

import lombok.RequiredArgsConstructor;
import org.blog.jwtexam.jwt.exception.CustomAuthenticationEntryPoint;
import org.blog.jwtexam.jwt.filter.JwtAuthenticationFilter;
import org.blog.jwtexam.jwt.util.JwtTokenizer;
import org.blog.jwtexam.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/userregform","/userreg","/","/login","/refreshToken","/loginform").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenizer), UsernamePasswordAuthenticationFilter.class)
//                .formLogin(Customizer.withDefaults())
                .formLogin(form -> form.disable())
                .sessionManagement(sessionManagement -> sessionManagement
//                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) //스프링시큐리티가 항상세션생성
//                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//필요시 생성(기본값)
//                        .sessionCreationPolicy(SessionCreationPolicy.NEVER)//생성하지는 않치만 이미 존재한다면 사용
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//생성하지도 않고, 존재해도 사용하지 않음 (JWT인증같은경우등)
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(customAuthenticationEntryPoint));

        return http.build();
    }
    public CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowedMethods(List.of("GET" , "POST" , "DELETE" , "PATCH" , "OPTION" , "PUT"));
        source.registerCorsConfiguration("/**",config);
        return source;
    }
    //비밀번호 암호화해서 넣기
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
