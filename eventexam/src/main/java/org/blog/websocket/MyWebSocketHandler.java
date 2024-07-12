package org.blog.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyWebSocketHandler extends TextWebSocketHandler {
    //현재 들어온 세션들을 관리할 저장소
    private static final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("세션연결시작"+session.getId());
        sessions.add(session);//세션이 들어올때마다 저장소에 넣어준다
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //Echo 서버는 메세지 보낸 세션에만 다시 메세지를 보내주면 끝
        //그렇다면 chat 서버는 뭘해야할까?

        String payload = message.getPayload();//실제메세지(헤더나 메타정보나 이런것들을 제외한 실질적 사용자가 보낸메세지)
        System.out.println("수신된메세지: "+payload);
        //채팅만들때 ECHO랑 비슷
        //session.sendMessage(new TextMessage("ECHO: "+payload));
        //저장소에 전체로 보내야함
        //synchronized : 동기화
        synchronized (sessions){
            for(WebSocketSession webSocketSession : sessions){
                if(webSocketSession.isOpen()){
                    webSocketSession.sendMessage(new TextMessage(session.getId()+": "+payload));
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("세션연결종료"+session.getId());
        sessions.remove(session);
    }
}
