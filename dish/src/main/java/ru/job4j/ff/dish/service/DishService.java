package ru.job4j.ff.dish.service;

import ru.job4j.ff.domain.model.Dish;

public interface DishService {

    void addDish(Dish dish);

    Dish removeDish(String dishName);

    void addDishPrice(int id, float price);

    float changeDishPrice(int id, float price);

    boolean checkAvailability(String dishName);
}
