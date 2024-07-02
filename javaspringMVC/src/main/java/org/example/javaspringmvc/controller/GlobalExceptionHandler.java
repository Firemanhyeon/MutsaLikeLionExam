package org.example.javaspringmvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);//해당클래스가 동작될때 발생되는 로그를 만들 수 있다.
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e , Model model){
        logger.error("Server Error: ",e);//로그에 에러를 기록한다.
        model.addAttribute("errorMessage",e.getMessage());
        return "error";
    }
}
