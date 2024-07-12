package org.blog.eventexam.ex03transactionevent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void registerItem(String name , int price){
        //아이템저장
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        Item result =itemRepository.save(item);
        //이벤트 등록
//        ItemRegistrationEvent customEvent = new ItemRegistrationEvent(this,result);
//        applicationEventPublisher.publishEvent(customEvent);
        //트랜잭션 적용한 이벤트 등록
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                ItemRegistrationEvent customEvent = new ItemRegistrationEvent(this,result);
                applicationEventPublisher.publishEvent(customEvent);
            }
        });
//        if(1==1){
//            throw new RuntimeException("강제예외발생");
//        }
    }
}
