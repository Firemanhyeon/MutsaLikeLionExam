package org.example.javaspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/custom")
    public String goView(){
        return "my-prefix-custom";
    }
}
