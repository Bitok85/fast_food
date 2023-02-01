package ru.job4j.ff.order.service;

import org.springframework.stereotype.Service;
import ru.job4j.ff.order.repository.OrderRepository;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.order.repository.StatusRepository;
import ru.job4j.ff.order.error.OrderNotFoundException;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private StatusRepository statusRepository;

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
    }

    public boolean orderReadiness(int id) {
        return statusRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order has no status")
        ).isReadiness();
    }
}
