package org.blog.filterexam4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.blog.filterexam4.entity.User;
import org.blog.filterexam4.service.UserService;


import java.io.IOException;

public class AuthenticationFilter implements Filter {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            String path = httpServletRequest.getRequestURI();//요청주소 ex) /welcome , /loginform, /admin/list
            String auth = null;
            Cookie[] cookies = httpServletRequest.getCookies();
            if(cookies!=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("auth")){
                        System.out.println("username찾았음"+cookie.getName());
                        auth = cookie.getValue();
                        System.out.println(auth);
                        break;
                    }
                }
            }
            System.out.println("auth:"+auth);
            if(auth != null){
                //요청 url에 따라서 http://localhost:8080/admin -- Role이 ROLE_ADMIN 인 사용자에게만 인가되도록
                User user = userService.findByUserName(auth);

                if(user!=null){
                    if(path.equals("/admin") && user.getRoles()
                                                .stream()
                                                .anyMatch(role-> role.getName().equals("ROLE_ADMIN"))
                                                ||
                                                (path.equals("/info") && user.getRoles()
                                                        .stream()
                                                        .anyMatch(role -> role.getName().equals("ROLE_USER")))
                    ){
                        filterChain.doFilter(servletRequest,servletResponse);
                        UserContext.clear();
                        return;
                    }
                }
                //권한이 없는 사용자가 접근 하려고 하는 경우
                if(path.equals("/admin") || path.equals("/info")){
                    httpServletResponse.sendRedirect("/access-denied");
                }
//                User user = new User();
//                user.setUsername(auth);
//                UserContext.setUser(user);
                assert user != null;
                user.setUsername(auth);
                UserContext.setUser(user);
                System.out.println("1111111");
            }
            if(path.equals("/admin") || path.equals("/info")){
                httpServletResponse.sendRedirect("/access-denied");
            }
            filterChain.doFilter(servletRequest , servletResponse);
        }finally {
            UserContext.clear();
        }
    }
}
