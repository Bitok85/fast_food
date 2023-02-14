package ru.job4j.ff.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.ff.domain.model.Card;
import ru.job4j.ff.domain.model.Customer;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

}
