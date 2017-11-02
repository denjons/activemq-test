package com.example.testproducer.reciever;


import com.example.testproducer.model.Request;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RequestReceiver {

    ArrayList<String> messages;


    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    @JmsListener(destination = "requests", containerFactory = "myFactory")
    public void receiveMessage(Request request) {
        messages.add(request.get_Id());
        System.out.println("Received <" + request + ">");
    }
}
