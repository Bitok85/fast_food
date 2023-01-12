package ru.job4j_fast_food.dish.service;

import ru.job4j_fast_food.domain.Dish;

public interface DishService {

    void addDish(String dishName);

    Dish removeDish(String dishName);

    void addDishPrice(float price);

    float changeDishPrice(float price);

    boolean checkAvailability(String dishName);
}
