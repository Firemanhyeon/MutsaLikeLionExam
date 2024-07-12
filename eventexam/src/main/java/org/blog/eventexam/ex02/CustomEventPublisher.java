package org.blog.eventexam.ex02;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomEventPublisher {
    //post-comment 예제 였다면 이 클래스가 CommentService였을것.
    private final ApplicationEventPublisher applicationEventPublisher;

    //댓글 등록 하는 메서드
    public void publisherEvent(final String message){
        System.out.println("publisherEvnet ThreadName" +Thread.currentThread().getName());
        //댓글 등록 하는 일을 하고

        //포스트에 있는 카운트를 업데이트
        CustomEvent customEvent = new CustomEvent(this,message);
        applicationEventPublisher.publishEvent(customEvent);


        System.out.println("publisherEvent 종료 ");
    }
}
