package ru.job4j.ff.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByCustomer(Customer customer);
}
