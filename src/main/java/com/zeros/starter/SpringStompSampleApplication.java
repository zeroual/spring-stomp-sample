package com.zeros.starter;

import com.zeros.conifg.SockJsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SockJsConfig.class})
public class SpringStompSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStompSampleApplication.class, args);
    }
}
