package ru.job4j_fast_food.dish.service;

import ru.job4j_fast_food.domain.Dish;

public interface DishService {

    void addDish(Dish dish);

    Dish removeDish(String dishName);

    void addDishPrice(int id, float price);

    float changeDishPrice(int id, float price);

    boolean checkAvailability(String dishName);
}
