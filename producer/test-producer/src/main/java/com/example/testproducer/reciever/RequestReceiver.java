package com.example.testproducer.reciever;


import com.example.testproducer.model.Request;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RequestReceiver {

    @JmsListener(destination = "requests", containerFactory = "myFactory")
    public void receiveMessage(Request request) {
        System.out.println("Received <" + request + ">");
    }
}
