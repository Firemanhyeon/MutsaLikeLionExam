package org.blog.redischat.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisMessagePublisher {
    //메세지가 들어오면 템플릿이랑 같이 일해야하니 redistemplate 의존 주입
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;

    //수신자측
    public void publish(String message){
        redisTemplate.convertAndSend(channelTopic.getTopic(),message);//채널에게 보낸다
    }

}
