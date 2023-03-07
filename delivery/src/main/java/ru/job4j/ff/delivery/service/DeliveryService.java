package ru.job4j.ff.delivery.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.delivery.repository.DeliveryOrderRepository;
import ru.job4j.ff.delivery.util.exception.OrderNotFoundException;
import ru.job4j.ff.domain.model.Courier;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {

    private final DeliveryOrderRepository repository;
    private final DeliveryKafkaProducer deliveryKafkaProducer;


    public void produceDeliveringOrder(int orderId) {
        try {
            Order deliveringOrder = findById(orderId);
            deliveringOrder.setStatus(Status.DELIVERING);
            repository.save(deliveringOrder);
            deliveryKafkaProducer.sendDeliveringOrder(deliveringOrder);
            log.info("Заказ c id {} передан курьеру м отправлен в сервис Notification", orderId);
        } catch (Exception e) {
            backOrderToDelivery(findById(orderId));
            log.error("Ошибка при передаче заказа c id {} в сервис Notification", orderId, e);
        }
    }

    public Order findById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Заказ " + id + " не найден!")
        );
    }

    public void takeOrder(Order order, Courier courier) {
        order.setCourier(courier);
        repository.save(order);
    }

    public void deliveredOrder(Order order) {
        order.setStatus(Status.DELIVERED);
        repository.save(order);
    }


    private void backOrderToDelivery(Order order) {
        order.setStatus(Status.SENT_TO_DELIVERY);
        repository.save(order);
    }
}
