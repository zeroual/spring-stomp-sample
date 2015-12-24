package com.zeros.conifg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by zeroual on 23/12/2015.
 */

@Configuration
//@EnableWebSocket to enable native or sockJs websockets
@ComponentScan("com.zeros.handlers")
@EnableWebSocketMessageBroker

public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//        This path is distinct from any destination path that you might
//        send or receive messages from. It’s the endpoint that a client would connect to before
//        subscribing to or publishing to a destination path.
        stompEndpointRegistry.addEndpoint("/stomp").withSockJS();
    }

//    This method is optional. If you don’t override
//    it, you’ll get a simple in-memory message broker configured to handle messages prefixed
//    with /topic.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // all message prefixed with /queue or /topic are destined to the broker
        registry.enableSimpleBroker("/queue", "/topic");
        // all message prefixed with /api are routed to the app (handler with the annotation @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");
    }
}
