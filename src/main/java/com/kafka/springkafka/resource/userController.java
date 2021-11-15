package com.kafka.springkafka.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class userController {

    @Autowired
   private KafkaTemplate<String,String> kafkaTemplate;
    private String topic;

    @GetMapping ("/publish/{message}")
    public String post(@PathVariable("message") final  String message){


        kafkaTemplate.send(topic,message);
        return "Published successfully";

    }
}
