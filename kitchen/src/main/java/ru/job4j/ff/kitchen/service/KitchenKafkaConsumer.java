package ru.job4j.ff.kitchen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.kitchen.repository.KitchenOrderRepository;

@Service
@RequiredArgsConstructor
public class KitchenKafkaConsumer {

    private final KitchenOrderRepository repository;

    @KafkaListener(topics = "payedOrder", groupId = "fastFood")
    public void consumePayedOrder(Order order) {
        order.setStatus(Status.COOKING);
        repository.save(order);
    }
}
