package com.zeros.conifg;

import com.zeros.handlers.PingHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by zeroual on 23/12/2015.
 */

@Configuration
@EnableWebSocket
public class SockJsConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new PingHandler(), "/websocket/ping").withSockJS();
    }
}
