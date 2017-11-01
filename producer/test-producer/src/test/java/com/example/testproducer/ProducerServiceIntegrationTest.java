package com.example.testproducer;


import com.example.testproducer.model.Request;
import com.example.testproducer.reciever.RequestReceiver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProducerServiceIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RequestReceiver requestReceiver;

    ArrayList<String> messages;

    @Before
    public void setup(){
        messages = new ArrayList<String>();
    }

    @Test
    public void ping(){

        String body = testRestTemplate.getForObject("/ping", String.class);
        assertThat(body.contains("service is running")).isTrue();

    }

    @Test
    public void addRequestTest() throws InterruptedException {

        requestReceiver.setMessages(messages);

        Request request = new Request();

        for (int i = 0; i < 50; i++) {
            request.setId(UUID.randomUUID().toString());
            request.setRequest("some request "+i);
            request.setUserId(UUID.randomUUID().toString());
            ArrayList<String> tags = new ArrayList<String>();
            tags.add("Dennis");
            request.setTags(tags);
            testRestTemplate.postForLocation("/add", request);
        }

        Thread.sleep(1000);

        assertEquals(50, messages.size());

    }

}
