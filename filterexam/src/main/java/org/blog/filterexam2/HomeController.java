package org.blog.filterexam2;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
@RequiredArgsConstructor

public class HomeController {

    private final UserService userService;



    @GetMapping("/")
    public String hello(){
        return "hello";
    }
    @GetMapping("/home")
    public String home(){
        log.info("home()실행");
        return "home";
    }
    @GetMapping("/hi")
    public String hi(){
        User user = UserContext.getUser();
        log.info(user.toString());
        return "hi";
    }
}
