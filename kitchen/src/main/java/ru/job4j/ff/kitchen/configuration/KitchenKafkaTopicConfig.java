package ru.job4j.ff.kitchen.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KitchenKafkaTopicConfig {

    @Bean
    public NewTopic cookedOrder() {
        return TopicBuilder.name("cookedOrder")
                .build();
    }
}
