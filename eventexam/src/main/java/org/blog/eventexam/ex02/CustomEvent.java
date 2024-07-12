package org.blog.eventexam.ex02;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

//이벤트를 정의하는 클래스
@Getter
public class CustomEvent extends ApplicationEvent {
    private String message;


    public CustomEvent(Object source,String message) {
        super(source);
        this.message=message;
    }
}
