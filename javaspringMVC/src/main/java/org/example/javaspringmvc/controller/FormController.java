package org.example.javaspringmvc.controller;

import jakarta.validation.Valid;
import org.example.javaspringmvc.domain.UserForm;
import org.example.javaspringmvc.domain.UserForm1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("userForm" , new UserForm());
        return "form";
    }
//    @PostMapping("/submitForm")
//    public String submitForm(@RequestParam String username , @RequestParam String password){
//        System.out.println(username);
//        System.out.println(password);
//
//        return "result";
//    }
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute UserForm userForm ,BindingResult bindingResult){
        if (bindingResult.hasErrors()){//유효성검사에서 에러가 발견되었다면 form.html로 리턴
            return "form";
        }
        return "result";
    }
}
