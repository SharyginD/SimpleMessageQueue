package org.example.configuration;

import org.example.service.producer.QueueProducer;
import org.example.service.producer.impl.KafkaProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    @ConditionalOnProperty(name = "message.queue.service", havingValue = "kafka")
    public QueueProducer kafkaService() {
        return new KafkaProducer();
    }
}
