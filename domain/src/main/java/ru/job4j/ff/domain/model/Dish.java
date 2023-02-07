package ru.job4j.ff.domain.model;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {

    @EqualsAndHashCode.Include
    private int id;

    private String name;
    private String type;
    private String description;
    private float price;
    private int cockingTime;
    private byte[] photo;
    private boolean availability;



}
