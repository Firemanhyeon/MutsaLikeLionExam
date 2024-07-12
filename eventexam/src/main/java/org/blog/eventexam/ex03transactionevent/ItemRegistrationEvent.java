package org.blog.eventexam.ex03transactionevent;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ItemRegistrationEvent extends ApplicationEvent {
    Item item;

    public ItemRegistrationEvent(Object source, Item item) {
        super(source);
        System.out.println("생성자생성");
        this.item = item;
    }
}
