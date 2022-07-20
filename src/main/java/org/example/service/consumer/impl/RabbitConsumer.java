package org.example.service.consumer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@EnableRabbit
public class RabbitConsumer {

    Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    @RabbitListener(queues = "queue1")
    public void worker1(String message) {
        logger.info("Message from worker1 : {}", message);
    }

    @RabbitListener(queues = "queue1")
    public void worker2(String message) {
        logger.info("Message from worker2 : {}", message);
    }
}
