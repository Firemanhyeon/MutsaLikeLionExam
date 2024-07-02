package org.blog.filterexam3;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.blog.filterexam2.User;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{

            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

            String auth = null;
            Cookie[] cookies = httpServletRequest.getCookies();
            if(cookies!=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("username")){
                        auth = cookie.getValue();

                        break;
                    }
                }
            }
            User user = new User();
            user.setUsername(auth);
            UserContext.setUser(user);

            filterChain.doFilter(servletRequest , servletResponse);
        }finally {
            UserContext.clear();
        }
    }
}
