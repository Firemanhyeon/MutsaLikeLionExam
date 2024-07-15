package org.blog.securitychat.config;

import lombok.RequiredArgsConstructor;
import org.blog.securitychat.security.CustomUserDetailsService;
import org.blog.securitychat.websocket.CustomHandshakeInterceptor;

import org.blog.securitychat.websocket.MyWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final CustomHandshakeInterceptor customHandshakeInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(),"/ws").setAllowedOrigins("*")
                .addInterceptors(customHandshakeInterceptor);
    }
}
