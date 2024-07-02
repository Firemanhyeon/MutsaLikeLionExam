package org.blog.realprojectexam.controller;

import lombok.RequiredArgsConstructor;
import org.blog.realprojectexam.domain.User;
import org.blog.realprojectexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userregform")
    public String userregform(){
        return "user/userregform";
    }

    @PostMapping("/userreg")
    public String userreg(@ModelAttribute("user") User user , BindingResult result){
        //에러를 가지고 들어오면 회원가입폼으로 다시
        if(result.hasErrors()){
            return "redirect:userregform";
        }
        //중복체크
        User byUserName  = userService.findByUserName(user.getUsername());
        if(byUserName!=null){
            result.rejectValue("username" , null,"이미 사용중인 아이디입니다.");
            return "user/usererror";
        }
        userService.registUser(user);
        return "redirect:/welcome";

    }

    @GetMapping("/welcome")
    public String welcome(){
        return "user/welcome";
    }
    @GetMapping("/loginform")
    public String loginform(){
        return "user/loginform";
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
