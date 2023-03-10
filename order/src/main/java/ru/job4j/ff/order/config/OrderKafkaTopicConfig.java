package ru.job4j.ff.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class OrderKafkaTopicConfig {

    @Bean
    public NewTopic paymentOrder() {
        return TopicBuilder.name("newOrder")
                .build();
    }

    @Bean
    public NewTopic notificationOrder() {
        return TopicBuilder.name("notificationOrder")
                .build();
    }
}
