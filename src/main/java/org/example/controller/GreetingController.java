package org.example.controller;

import org.example.service.producer.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final QueueProducer queueProducer;

    @Autowired
    public GreetingController(@Qualifier("queue") QueueProducer queueProducer) {
        this.queueProducer = queueProducer;
    }

    @PostMapping("/message")
    public String getMessage(@RequestBody String message) {
        for (int i = 0; i < 10; i++) {
            queueProducer.produce(message);
        }
        return "Success send message to queue";
    }
}
