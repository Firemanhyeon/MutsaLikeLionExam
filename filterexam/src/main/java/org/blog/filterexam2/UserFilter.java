package org.blog.filterexam2;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //사용자가 요청하면서 보낸 값이 있다면 추출해서 UserContext에다 저장하는 코드 구현
        try{
            User user = new User();
            user.setUsername("carami");
            user.setPassword("1234");
            UserContext.setUser(user);
            filterChain.doFilter(servletRequest,servletResponse);

        }finally {
            UserContext.clear();//쓰레드풀을 사용하므로 기존에 사용됐던 ㅅ스레드를 또 쓸수있기 때문에 비워줘야한다.
        }

    }
}
