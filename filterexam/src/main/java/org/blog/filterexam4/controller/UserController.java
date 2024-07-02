package org.blog.filterexam4.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.blog.filterexam4.entity.User;
import org.blog.filterexam4.filter.UserContext;
import org.blog.filterexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //로그인폼이동
    @GetMapping("loginform")
    public String loginform(){
        return "loginform";
    }

    //로그인로직처리
    @PostMapping("login")
    public String loginform(@ModelAttribute("user") User user , HttpServletResponse response){

        User user1 = userService.findByUserName(user.getUsername());
        if(user1!=null && user.getPassword().equals(user1.getPassword())){
            System.out.println("로그인성공");
            Cookie cookie= new Cookie("auth" , user.getUsername());
            cookie.setPath("/");
            cookie.setHttpOnly(true);//자바스크립트로는 쿠키에 접근할 수 없다.
            response.addCookie(cookie);
        }
        return "redirect:/welcome";
    }
    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        //쿠키를 삭제하면 로그아웃이 되는데..
        //브라우저의 쿠키는 서버에서 삭제할 수는 없다.
        //그래서,  똑같은 이름의 쿠키를 만들어서 보낸다.
        Cookie cookie = new Cookie("auth","");
        cookie.setPath("/");
        cookie.setMaxAge(0);  //쿠키유지시간!!

        response.addCookie(cookie);

        return "redirect:/loginform";
    }

    //welcome페이지
    @GetMapping("/welcome")
    public String welcome(){
        User user = UserContext.getUser();
        if(user != null){
            System.out.println("유저컨텍스트"+user);
            return "welcome";
        }
        else{
            System.out.println("쿠키없음"+user);
            return "redirect:/loginform";
        }
    }
    //info페이지
    @GetMapping("/info")
    public String info(HttpServletRequest request){
//        User user = UserContext.getUser();
//        if(user != null)
        System.out.println("info로 이동");
            return "info";
//        else
//            return "redirect:/loginform";
    }
    @GetMapping("/access-denied")
    public String accessDenied(HttpServletRequest request){

        return "access-denied";

    }

}
