package org.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
//범위 지정해서 직접넣어줄수있음
    @Pointcut("execution(* hello()))")
    public void pc2(){}
    @Pointcut("execution(* org.example.aopexam.SimpleService.*(..))")// 시점을 저장하는 메소드로 선언가능
    public void pc(){}

    //메소드실행전
    @Before("pc()")//실행되는 시점 정의(pointcut)
    public void before(JoinPoint joinPoint){
        System.out.println("Before ::::::::::::::::"+joinPoint.getSignature().getName());
    }

    //메소드실행후
//    @After("execution(* org.example.aopexam.SimpleService.*(..))")
//    public void after(JoinPoint joinPoint){
//        System.out.println("After ::::::::::::::::::"+joinPoint.getSignature().getName());
//    }
    @After("pc2()")
    public void after(JoinPoint joinPoint){
        System.out.println("After ::::::::::::::::::"+joinPoint.getSignature().getName());
    }
    //메소드실행하는데 예외없이 잘 처리된경우
    @AfterReturning(pointcut = "execution(String org.example.aopexam.*.*(..))" , returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturning ::::::::::::::::"+joinPoint.getSignature().getName());
    }
    //매개변수도 가로챌 수 있다
    @Before("execution(* setName(..))")
    public void beforeName(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("매개변수가로채기");
        for(Object arg : args){
            System.out.println(arg);
        }
    }
    //예외를 발생시켰을때
    @AfterThrowing(value = "pc2()" , throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("AfterThrowing ::::::::::::::::");
        System.out.println("exceptionValue : "+ex);
    }

    //실제 호출된 메서드가 실행되기전,후에 할일 구현
    @Around("pc()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aroundrun:::::::::::::::::::실제 호출된 메서드가 실행되기전에 할일 구현 " );
        String value = (String)joinPoint.proceed();
        System.out.println("Aroundrun:::::::::::::::::::실제 호출된 메서드가 실행된 후에에 할일 구현 ");
        value+="hihihihihi";
        return value;
    }
}
