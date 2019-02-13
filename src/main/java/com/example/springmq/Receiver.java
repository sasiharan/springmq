package com.example.springmq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}