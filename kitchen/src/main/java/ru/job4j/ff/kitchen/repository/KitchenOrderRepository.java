package ru.job4j.ff.kitchen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.ff.kitchen.model.KitchenOrder;

import java.util.Optional;

@Repository
public interface KitchenOrderRepository extends MongoRepository<KitchenOrder, Integer> {

    Optional<KitchenOrder> findById(int id);
}
