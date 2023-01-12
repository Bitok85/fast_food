package ru.job4j_fast_food.domain;

import lombok.Data;

@Data
public class Dish {

    private String name;
    private String type;
    private float price;
    private boolean availability;

}
