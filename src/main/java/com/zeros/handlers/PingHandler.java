package com.zeros.handlers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by zeroual on 23/12/2015.
 */
@Controller
public class PingHandler {

    @MessageMapping("/ping")
    public void handlePing(String ping){
        System.out.println("Ping Received:"+ping);
    }
}
