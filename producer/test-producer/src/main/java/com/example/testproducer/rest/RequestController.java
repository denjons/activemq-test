package com.example.testproducer.rest;

import com.example.testproducer.model.Request;
import com.example.testproducer.producer.RequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Errors;

import javax.validation.Valid;

@RestController
public class RequestController {

    @Autowired
    RequestProducer requestProducer;

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    public String ping(){
        return "request service is running";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add", consumes = "application/json")
    public ResponseEntity<?> addRequest(@Valid @RequestBody Request request, Errors error){

        if(error.hasErrors() || request == null){
            error.getAllErrors().stream().forEach(System.out::println);
           return  ResponseEntity.badRequest().body("invalid request");
        }

        System.out.println("got request with id: "+request.get_Id());
        requestProducer.sendRequest(request);

        return ResponseEntity.ok("added request");
    }
}
