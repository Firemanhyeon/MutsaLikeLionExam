package org.blog.filterexam;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/user/*")
public class TestFilter implements Filter {
    public TestFilter() {
        log.info("TestFilter생성자실행");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TestFilter init()실행");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TestFilter doFilter()메서드 실행 전 실행");
        filterChain.doFilter(servletRequest , servletResponse);
        log.info("TestFilter doFilter()메서드 실행 후 실행");

    }

    @Override
    public void destroy() {
        log.info("TestFilter destroy()실행");

    }
}
