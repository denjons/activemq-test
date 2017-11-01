package com.example.testproducer.rest;

import com.example.testproducer.model.Request;
import com.example.testproducer.producer.RequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RequestController {

    @Autowired
    RequestProducer requestProducer;

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    public String ping(){
        return "request service is running";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add", consumes = "application/json")
    public void addRequest(@RequestBody Request request){

        System.out.println("got request with id: "+request.getId());
        requestProducer.sendRequest(request);
    }
}
