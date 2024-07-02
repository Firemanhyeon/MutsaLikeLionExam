package org.example.javaspringmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("visitCount2")//애노테이션을 이용한 예 visitCount2가 나오면 session에다가 저장해준다
public class SessionController {

    @ModelAttribute("visitCount2")
    public Integer initVisitCount2(){
        return 0;
    }
    @GetMapping("/visit2")
    public String trackVisit(@ModelAttribute("visitCount2") Integer visitCount2 , Model model){
                            //@ModelAttribute("visitCount2") Integer visitCount2 이게 session.setAttribute 같은 역할이다.

        visitCount2++;
        model.addAttribute("visitCount2" , visitCount2);
        return "visit2";
    }
    //초기화
    @GetMapping("/resetVisit")
    public String resetVisit(SessionStatus status){
        status.setComplete();
        return "redirect:/visit2";
    }
//HttpSession 을 직접 이용한 예.
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session , Model model){
//        Integer visitCount = (Integer) session.getAttribute("visitCount");
//        if(visitCount==null){
//            visitCount=0;
//        }
//        visitCount++;
//        session.setAttribute("visitCount",visitCount);
//        model.addAttribute("visitCount" , visitCount);
//        return "visit2";
//    }


}
