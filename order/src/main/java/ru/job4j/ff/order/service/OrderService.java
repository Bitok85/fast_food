package ru.job4j.ff.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Dish;
import ru.job4j.ff.order.util.exception.OrderNotFoundException;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderKafkaProducer orderKafkaProducer;


    public Order findOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException(
                        String.format("Order %s not found", id)
                )
        );
    }

    public List<Order> findAllByCustomer(Customer customer) {
        return findAllByCustomer(customer);
    }
    public void createOrder(Order order) {
        try {
            order.setStatus(Status.CREATED);
            order.setAmount(calculateOrderAmount(order));
            orderKafkaProducer.sendOrderToPayment(order);
            orderRepository.save(order);
        } catch (RuntimeException e) {
            order.setStatus(Status.CANCELED);
            orderKafkaProducer.sendOrderToNotification(order);
            orderRepository.save(order);
            log.error(
                    "Ошибка на этапе создания заказа № {}, заказ отменён!", order.getId(), e
            );
        }
    }

    public float calculateOrderAmount(Order order) {
        return (float) order.getDishList().stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }

    public Status orderStatus(int id) {
        return orderRepository.findById(id).orElseThrow()
                .getStatus();
    }
}
