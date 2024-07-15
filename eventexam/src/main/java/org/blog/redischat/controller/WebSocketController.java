package org.blog.redischat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {
    @GetMapping("/")
    public String home(){
        return "index.html";
    }
    @GetMapping("/chat")
    public String chat(){
        return "chat.html";
    }
}
