package ru.job4j.ff.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.payment.repository.PaymentOrderRepository;
import ru.job4j.ff.payment.util.exception.OrderNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentOrderRepository repository;
    private final PaymentKafkaProducer paymentKafkaProducer;


    public void producePayedOrder(int orderId) {
        try {
            Order payedOrder = findById(orderId);
            payedOrder.setStatus(Status.PAYED);
            repository.save(payedOrder);
            paymentKafkaProducer.sendPayedOrder(payedOrder);
            log.info("Оплаченный заказ c id {} отправлен в сервис Kitchen", orderId);
        } catch (Exception e) {
            produceCanceledOrder(orderId);
            log.error("Ошибка при отправке олаченного заказа c id {} в сервис Kitchen", orderId, e);
        }
    }

    public void produceCanceledOrder(int orderId) {
        try {
            Order canceledOrder = findById(orderId);
            canceledOrder.setStatus(Status.CANCELED);
            paymentKafkaProducer.sendCanceledOrder(canceledOrder);
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
