package org.blog.eventexam.ex01;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//서버가 실행될때 시작되는 이벤트
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("애플리케이션 시작");
    }
}
