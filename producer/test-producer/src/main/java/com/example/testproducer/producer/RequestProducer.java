package com.example.testproducer.producer;


import com.example.testproducer.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class RequestProducer {

    @Autowired
    JmsTemplate jmsTemplate;



    public void sendRequest(Request request){
        jmsTemplate.convertAndSend("requests", request);
    }

}
