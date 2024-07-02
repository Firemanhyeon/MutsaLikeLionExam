package org.example.javaspringmvc.controller;

import org.example.javaspringmvc.domain.Item;
import org.example.javaspringmvc.domain.Product;
import org.example.javaspringmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Array;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {

    @GetMapping("/guest/{name}")
    public String guest(@PathVariable String name){
        System.out.println(name);
        return "redirect:/dateTime";
    }

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("welcomemsg", "helloWorld");
        List<Item> list = Arrays.asList(new Item("pen" , 3000),
                                        new Item("notebook" , 40000),
                                        new Item("cup" , 30000));
        model.addAttribute("itemList" , list);
        return "welcome/welcome";
    }



    @GetMapping("/products")
    public String productList(Model model){
        List<Product> products = Arrays.asList(new Product(1,"Apple" , 3000),
                new Product(2,"Banana" , 40000),
                new Product(3,"Cherry" , 30000));
        model.addAttribute("productList" , products);
        return "welcome/product";
    }
    @GetMapping("/example")
    public String showExam(Model model){
        model.addAttribute("username", "carami");
        model.addAttribute("isAdmin",true);
        model.addAttribute("languages", new String[]{"English", "Spanish","German"});

        return "welcome/exam";
    }


    @GetMapping("/users")
    public String userList(Model model){
        List<User> users = Arrays.asList(new User("관리자1" , true),
                                        new User("사용자1" , false),
                                        new User("사용자2" , false),
                                        new User("사용자3" , false));
        model.addAttribute("userList",users);
        return "welcome/userList";
    }
    @GetMapping("/list")
    public String showList(Model model){
        List<String> list = Arrays.asList("Item1" ,"Item2" ,"Item3" ,"Item4" ,"Item5" ,"Item6" ,"Item7" ,"Item8" ,"Item9" ,"Item10");
        model.addAttribute("list" , list);
        return "welcome/list";
    }

    @GetMapping("/dateTime")
    public String showDateTime(Model model){
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        model.addAttribute("currentDate" , date);
        model.addAttribute("currentDateTime" , dateTime);
        model.addAttribute("currentTime" , time);
        model.addAttribute("currentZonedDateTime" , zonedDateTime);
        return "welcome/datetime";
    }
}
