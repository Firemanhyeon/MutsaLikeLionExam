package org.blog.eventexam.ex01;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//이벤트가 발생했을때 해야할 일 구현하는 클래스
@Component
public class CustomEventListener {

    @EventListener
    public void handleCustomEvent(CustomEvent customEvent){
        System.out.println("이벤트가 발생했을때 해야할 일 구현" +customEvent.getMessage());
        System.out.println("commentCount update 실행");
        //ex)댓글이 달렸을때 댓글 서비스에서 댓글이 등록되고 post에 있는 댓글 수 필드에 업데이트시켜줘야하는상황에서
        //commentUpdateCount같은 메서드를 호출할 수 있다.
    }
}
