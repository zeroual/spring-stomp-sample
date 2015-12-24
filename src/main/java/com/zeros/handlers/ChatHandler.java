package com.zeros.handlers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by zeroual on 23/12/2015.
 */
@Controller
public class ChatHandler {

    // handle request to /app/ping
    @MessageMapping("/chat")
    public Message handlePing(Message message){
        System.out.println("Ping Received:"+message);
        return message;
    }

//    @SubscribeMapping methods can only handle messages for destinations
//    that are prefixed with /app.
    @SubscribeMapping("")
    public void toto(){

    }
    private static class Message{

        private String body;
        public Message() {

        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "body='" + body + '\'' +
                    '}';
        }
    }
}
