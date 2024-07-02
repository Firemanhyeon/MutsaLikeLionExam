package org.blog.filterexam3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.blog.filterexam2.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpResponse;

@Controller
public class UserController {
    @GetMapping("loginform")
    public String loginForm(){
        return "loginform";
    }
    @PostMapping("login")
    public String login(@ModelAttribute("user") User user , HttpServletResponse httpResponse){
        if(user.getUsername().equals("carami") && user.getPassword().equals("123")){
            Cookie cookie = new Cookie("username" , user.getUsername());
            httpResponse.addCookie(cookie);
            return "redirect:/info";

        }else{
            return "redirect:/loginform";
        }

    }

    @GetMapping("info")
    public String welcome(HttpServletRequest httpServletRequest){
        User user = UserContext.getUser();
        if(user!=null){
            return "welcome";
        }else{
            return "redirect:/loginform";
        }
    }
}
