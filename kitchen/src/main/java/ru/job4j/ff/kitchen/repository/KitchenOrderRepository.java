package ru.job4j.ff.kitchen.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.ff.domain.model.Order;

public interface KitchenOrderRepository extends CrudRepository<Order, Integer> {
}
