package ru.job4j.ff.order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;

@Service
public class OrderKafkaProducer {

    private KafkaTemplate<String, Order> orderKafkaTemplate;

    public OrderKafkaProducer(KafkaTemplate<String, Order> orderKafkaTemplate) {
        this.orderKafkaTemplate = orderKafkaTemplate;
    }

    public void sendOrderToNotification(Order order) {
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "newOrder")
                .build();
        orderKafkaTemplate.send(message);
    }

    public void sendOrderToKitchen(Order order) {
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "preorder")
                .build();
        orderKafkaTemplate.send(message);
    }
}
