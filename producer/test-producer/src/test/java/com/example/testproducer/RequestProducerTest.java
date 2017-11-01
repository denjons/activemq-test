package com.example.testproducer;


import com.example.testproducer.model.Request;
import com.example.testproducer.producer.RequestProducer;
import com.example.testproducer.reciever.RequestReceiver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestProducerTest {

    @Autowired
    RequestProducer requestProducer;

    @Autowired
    RequestReceiver requestReceiver;

    ArrayList<String> messages;
    UUID uuid;

    @Before
    public void setup(){
        messages = new ArrayList<String>();
    }

    @Test
    public void senRequestTest() throws InterruptedException {

        requestReceiver.setMessages(messages);

        Request request = new Request();
        for (int i = 0; i < 50; i++) {
            request.setId(UUID.randomUUID().toString());
            request.setRequest("some request "+i);
            request.setUserId(UUID.randomUUID().toString());
            ArrayList<String> tags = new ArrayList<String>();
            tags.add("Dennis");
            request.setTags(tags);
            requestProducer.sendRequest(request);
        }

        System.out.println("waiting one second");
        Thread.sleep(1000);

        assertEquals(50, messages.size());

    }
}
