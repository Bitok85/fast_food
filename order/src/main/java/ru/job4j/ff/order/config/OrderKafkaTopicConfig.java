package ru.job4j.ff.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class OrderKafkaTopicConfig {

    @Bean
    public NewTopic newOrder() {
        return TopicBuilder.name("newOrder")
                .build();
    }

    @Bean
    public NewTopic newCard() {
        return TopicBuilder.name("newCard")
                .build();
    }

    @Bean
    public NewTopic preorder() {
        return TopicBuilder.name("preorder")
                .build();
    }
}
