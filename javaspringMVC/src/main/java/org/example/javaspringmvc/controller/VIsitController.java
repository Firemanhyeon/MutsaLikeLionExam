package org.example.javaspringmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VIsitController {

    @GetMapping("/visit")
    public String showVisit(@CookieValue(name="lastVisit",defaultValue = "N/A") String lastVisit,
                            HttpServletResponse httpServletResponse , Model model , HttpServletRequest httpServletRequest){

        Cookie cookie = new Cookie("lastVisit" , "carami");//쿠키생성
        Cookie cookie2 = new Cookie("lastVisit2" , "carami2");//쿠키생성

        cookie.setMaxAge(60*60);//쿠키유효시간설정

        httpServletResponse.addCookie(cookie);//서버에 쿠키넣기
        httpServletResponse.addCookie(cookie2);//서버에 쿠키넣기

        Cookie[] cookies = httpServletRequest.getCookies();//쿠키확인
        for(Cookie c : cookies){
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }
        model.addAttribute("lastVisit" , lastVisit);
        return "visit";
    }

}
