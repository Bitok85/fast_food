package ru.job4j.ff.kitchen.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.kitchen.repository.KitchenOrderRepository;
import ru.job4j.ff.kitchen.util.exception.OrderNotFoundException;


@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderService {

    private final KitchenKafkaConsumer kitchenKafkaConsumer;

    private final KafkaOrderProducer kafkaOrderProducer;
    private final KitchenOrderRepository repository;



    public void producePayedOrder(int orderId) {
        try {
            Order cookedOrder = findById(orderId);
            cookedOrder.setStatus(Status.COOKED);
            repository.save(cookedOrder);
            kafkaOrderProducer.sendCookedOrder(cookedOrder);
            log.info("Оплаченный заказ c id {} отправлен в сервис Delivery", orderId);
        } catch (Exception e) {
            produceCanceledOrder(orderId);
            log.error("Ошибка при отправке олаченного заказа c id {} в сервис Delivery", orderId, e);
        }
    }

    public void produceCanceledOrder(int orderId) {
        try {
            Order canceledOrder = findById(orderId);
            canceledOrder.setStatus(Status.CANCELED);
            kafkaOrderProducer.sendCanceledOrder(canceledOrder);
            repository.save(canceledOrder);
        } catch (Exception e) {
            log.error(
                    "Ошибка при отмене заказа! ВНИМАНИЕ! клиент с id {} может быть не уведомлен!",
                    findById(orderId).getCustomer().getId(), e
            );
        }
    }

    public Order findById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Заказ " + id + " не найден!")
        );
    }



}
