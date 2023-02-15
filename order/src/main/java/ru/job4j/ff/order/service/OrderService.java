package ru.job4j.ff.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.exception.OrderNotFoundException;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
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
        orderRepository.save(order);
        orderKafkaProducer.sendOrder(order);
    }

    public Status orderStatus(int id) {
        return orderRepository.findById(id).orElseThrow()
                .getStatus();
    }
}
