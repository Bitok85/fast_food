package ru.job4j.ff.payment.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PaymentKafkaTopicConfig {

    @Bean
    public NewTopic payedOrder() {
        return TopicBuilder.name("payedOrder")
                .build();
    }

    @Bean
    public NewTopic notificationOrder() {
        return TopicBuilder.name("notificationOrder")
                .build();
    }
}
