package org.example.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    //핵심관점.target
    public String doSomething(){
        System.out.println("doSomething");
        return "Doing something";
    }

    public void hello(){
        System.out.println("hello");
        if(1==1){
            throw new RuntimeException();
        }
    }

    public void setName(String name){
        System.out.println("setNamerun "+name);
    }


}
