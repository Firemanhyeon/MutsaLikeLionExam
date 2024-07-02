package org.blog.filterexam;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

//필터는 필터자체를 요청할 수 없다.
//필터는 어떤 요청을 처리하기 전 , 후 에 해야할 일들을 처리할 수 있다.
@Slf4j
@Component
@WebFilter(urlPatterns = "/hi")
public class FirstFilter implements Filter {
    public FirstFilter() {
        log.info("filter생성자 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("firstfilter init()실행");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("firstfilter doFilter()메서드 실행 전 실행");
        filterChain.doFilter(servletRequest , servletResponse);
        log.info("firstfilter doFilter()메서드 실행 후 실행");

    }

    @Override
    public void destroy() {
        log.info("firstfilter destroy()실행");

    }
}
