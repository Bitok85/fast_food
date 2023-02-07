package ru.job4j.ff.dish.service;

import ru.job4j.ff.domain.model.Dish;

import java.util.List;

public interface DishService {

    void addDish(Dish dish);

    Dish findDishById(int id);

    Dish findDishByName(String name);

    Dish updateDish(Dish dish);

    int cockingTime(String name);

    boolean deleteDish(String name);

    List<Dish> findAll();
}
