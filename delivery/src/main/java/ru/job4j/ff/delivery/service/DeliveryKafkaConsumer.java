package ru.job4j.ff.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.delivery.repository.DeliveryOrderRepository;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;

@Service
@RequiredArgsConstructor
public class DeliveryKafkaConsumer {

    private final DeliveryOrderRepository repository;

    @KafkaListener(topics = "cookedOrder", groupId = "fastFood")
    public void consumePayedOrder(Order order) {
        order.setStatus(Status.SENT_TO_DELIVERY);
        repository.save(order);
    }
}
