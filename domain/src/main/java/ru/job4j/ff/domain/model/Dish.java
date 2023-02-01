package ru.job4j.ff.domain.model;

import lombok.Data;

@Data
public class Dish {

    private String name;
    private String type;
    private float price;
    private boolean availability;

}
