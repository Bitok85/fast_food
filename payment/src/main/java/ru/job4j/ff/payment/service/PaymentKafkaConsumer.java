package ru.job4j.ff.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.payment.repository.PaymentOrderRepository;

@Service
@RequiredArgsConstructor

public class PaymentKafkaConsumer {
    private final PaymentOrderRepository repository;

    @KafkaListener(topics = "newOrder", groupId = "fastFood")
    public void consumePayedOrder(Order order) {
        order.setStatus(Status.COOKING);
        repository.save(order);
    }
}
