package ru.job4j.ff.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.ff.domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    Optional<Dish> findByName(String name);
    boolean deleteByName(String name);

    List<Dish> findAll();


}
