package ru.job4j.ff.payment.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.ff.domain.model.Order;

import java.util.List;

public interface PaymentOrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByCustomer();
}
