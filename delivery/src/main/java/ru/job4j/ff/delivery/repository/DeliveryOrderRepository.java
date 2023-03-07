package ru.job4j.ff.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.ff.domain.model.Order;

public interface DeliveryOrderRepository extends CrudRepository<Order, Integer> {
}
