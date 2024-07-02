package org.blog.filterexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    public HomeController() {
        log.info("HomeController 생성자 실행");  ;
    }

    @GetMapping
    public String home(){
        log.info("home()실행");
        return "home";
    }
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }
}
