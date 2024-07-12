package org.blog.websocketchat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketChatController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }
}
