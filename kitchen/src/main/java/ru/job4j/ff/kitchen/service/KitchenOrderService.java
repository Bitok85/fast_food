package ru.job4j.ff.kitchen.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;


@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderService {

    private final KitchenKafkaConsumer kitchenKafkaConsumer;

    private final KafkaOrderProducer kafkaOrderProducer;

   
    public void createKitchenOrderAndSendItBackToOrderService(Order order) {
        try {
            Order kitchenOrder = kitchenKafkaConsumer.consumePreorder(order);
            pause();
            updateToCooked(kitchenOrder);
            kafkaOrderProducer.sendCookedOrder(order);
        } catch (Exception e) {
            order.setStatus(Status.CANCELED);
            kafkaOrderProducer.sendCookedOrder(order);
            log.error("Ошибка при работе с заказом", e);
        }
    }

    public void updateToCooked(Order order) {
        order.setStatus(Status.COOKED);
    }
    private void pause() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
