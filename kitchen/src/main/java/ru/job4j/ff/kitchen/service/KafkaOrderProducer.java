package ru.job4j.ff.kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;

@Service
@RequiredArgsConstructor
public class KafkaOrderProducer {

    private KafkaTemplate<Order, String> kafkaTemplate;

    public void sendCookedOrder(Order order) {
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "cookedOrder")
                .build();
        kafkaTemplate.send(message);
    }
}
