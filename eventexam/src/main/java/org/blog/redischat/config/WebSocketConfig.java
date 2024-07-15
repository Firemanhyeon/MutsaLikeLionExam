package org.blog.redischat.config;

import lombok.RequiredArgsConstructor;
import org.blog.redischat.websocket.CustomHandshakeInterceptor;
import org.blog.redischat.websocket.MyWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final CustomHandshakeInterceptor customHandshakeInterceptor;
    private final MyWebSocketHandler myWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler,"/ws").setAllowedOrigins("*")
                //security와 함께써야할때 추가
                .addInterceptors(customHandshakeInterceptor);
    }
}
