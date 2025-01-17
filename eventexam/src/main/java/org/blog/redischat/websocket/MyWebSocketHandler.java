package org.blog.redischat.websocket;


import lombok.RequiredArgsConstructor;
import org.blog.redischat.redis.RedisMessagePublisher;
import org.blog.redischat.redis.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MyWebSocketHandler extends TextWebSocketHandler {
    //현재 들어온 세션들을 관리할 저장소
//    private static final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
    private final RedisMessagePublisher redisMessagePublisher;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("세션연결시작"+session.getId());
        RedisMessageSubscriber.addSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //Echo 서버는 메세지 보낸 세션에만 다시 메세지를 보내주면 끝
        //그렇다면 chat 서버는 뭘해야할까?

        String payload = message.getPayload();//실제메세지(헤더나 메타정보나 이런것들을 제외한 실질적 사용자가 보낸메세지)
        System.out.println("수신된메세지: "+payload);

        //현재 인증된 사용자 정보 가져옴
        //CustomHandshakeInterceptor에서 넣은 사용자 정보를 여기서 가져와서 해당 이름 띄워주기
        SecurityContext securityContext = (SecurityContext) session.getAttributes().get("SPRING_SECURITY_CONTEXT");
        String usernames = "Unknown user";

        if(securityContext!=null && securityContext.getAuthentication() !=null && securityContext.getAuthentication().getPrincipal() instanceof UserDetails){
            UserDetails userDetails = (UserDetails) securityContext.getAuthentication().getPrincipal();
            usernames = userDetails.getUsername();
        }

        redisMessagePublisher.publish(usernames+": "+payload);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("세션연결종료"+session.getId());
        RedisMessageSubscriber.removeSession(session);
    }
}
