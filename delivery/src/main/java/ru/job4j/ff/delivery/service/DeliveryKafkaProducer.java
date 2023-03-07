package ru.job4j.ff.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;

@Service
@RequiredArgsConstructor
public class DeliveryKafkaProducer {

    private final KafkaTemplate<Order, String> kafkaTemplate;

    public void sendDeliveringOrder(Order order) {
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "notificationOrder")
                .build();
        kafkaTemplate.send(message);
    }

}
