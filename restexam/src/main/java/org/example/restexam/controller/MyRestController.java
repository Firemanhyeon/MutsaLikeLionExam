package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    @GetMapping("/api/greeting")
    public Map<String,String> greet(@RequestParam(name = "name" , required = false , defaultValue = "World") String name){
                                                                    //반드시 넘겨오지 않아도 된다. 값넘겨오지않을때 default
        Map<String,String> response = new HashMap<>();
        response.put("message" , "Hello , "+name+"!");
        return response;
    }


    @GetMapping(value = "/poductjson/{id}" , produces = "application/json")
    public Product getProductAsJson(@PathVariable("id") Long id){
        return new Product(id,"Example Product" , 9.99);
    }

    @GetMapping(value = "/poductxml/{id}" , produces = "application/xml")
    public Product getProductAsXml(@PathVariable("id") Long id){
        return new Product(id,"Example Product" , 9.99);
    }
}
