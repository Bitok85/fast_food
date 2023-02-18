package ru.job4j.ff.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;

@Service
@RequiredArgsConstructor
public class OrderKafkaConsumer {

    @KafkaListener(topics = "cookedOrder", groupId = "fastFood")
    public Order consumeOrderFromKitchen(Order order) {
        return order;
    }
}
