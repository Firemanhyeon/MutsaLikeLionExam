package org.example.javaspringmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/content")
    public String content(){
        return "content";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest(){
        return "restbody Test";
    }

//    @GetMapping("greeting")
//    public String greet(String name , HttpServletRequest req){
//        System.out.println(req.getParameter("name"));
//        //Spring mvc가 직접 매개변수로 넣어주는 역할을 해줬다
    // model 대신에 req.setAttribute 사용해서 넣어줄수도있다.
//        return "greet";
//    }
    @GetMapping("greeting")
    public String greet(@RequestParam(name="abc" , required = false , defaultValue = "kang") String name ,
                        @RequestParam(name="age" , required = false , defaultValue = "10")int age){
        //request를 통해 받아온값을 name에 담아줘
        //required = 필수로받아와야하냐
        //defaultValue = 디폴트
        System.out.println(name);
        System.out.println(age);

        //얻은 값을 view로 다시보내기
        //model 사용
        return "greet";
    }

//    @GetMapping("greet")
//    public String greet1(@RequestParam(name="abc" , required = false , defaultValue = "kang") String name ,
//                        @RequestParam(name="age" , required = false , defaultValue = "10")int age , Model model){
//        //request를 통해 받아온값을 name에 담아줘
//        //required = 필수로받아와야하냐
//        //defaultValue = 디폴트
//        System.out.println(name);
//        System.out.println(age);
//
//        //얻은 값을 view로 다시보내기
//        //model 사용
//        model.addAttribute("name" , name);
//        model.addAttribute("age",age);
//        return "greet";
//    }
@GetMapping("greet")
public ModelAndView greet1(@RequestParam(name="abc" , required = false , defaultValue = "kang") String name ,
                     @RequestParam(name="age" , required = false , defaultValue = "10")int age , ModelAndView modelAndView){
    //request를 통해 받아온값을 name에 담아줘
    //required = 필수로받아와야하냐
    //defaultValue = 디폴트
    System.out.println(name);
    System.out.println(age);

    //모델과 보낼 뷰를 같이넘기기
    modelAndView.addObject("name" , name);
    modelAndView.addObject("age",age);

    modelAndView.setViewName("greet");
    return modelAndView;
}



}
