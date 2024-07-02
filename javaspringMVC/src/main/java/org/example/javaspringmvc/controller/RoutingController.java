package org.example.javaspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RoutingController {

    @GetMapping("/start")
    public String startProcess(Model model){
        model.addAttribute("forwardTest" , "carami");
        return "forward:/forward";//url forward 요청
    }

    @GetMapping("/forward")
    public String forward(){
        return "forwardPage";//model안에 넣었던값 여기서도 쓸 수 있다. url이 바뀌지않음
    }

    @GetMapping("/redirect")
    public String redirect(RedirectAttributes redirectAttributes){
        //model.addAttribute("redirectPage","hihi");
        redirectAttributes.addFlashAttribute("redirectPage", "hihi");//flash를 이용해서 값 유지하기
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")//url이 바뀜. model안에넣었던값 못쓴다.
    public String finalDestination(){
        return "redirectPage";
    }
}
