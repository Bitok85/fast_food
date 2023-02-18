package ru.job4j.ff.kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;

@Service
@RequiredArgsConstructor
public class KitchenKafkaConsumer {

    @KafkaListener(topics = "preorder", groupId = "fastFood")
    public Order consumePreorder(Order order) {
        return order;
    }


}
