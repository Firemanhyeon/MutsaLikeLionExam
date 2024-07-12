package org.blog.eventexam.ex03transactionevent;

import org.blog.eventexam.ex01.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class ItemRegistrationEventListener {

    @TransactionalEventListener
    public void handleCustomEvent(ItemRegistrationEvent event){
        System.out.println(event.getItem().getName()+"가 등록되었습니다");
    }
}
