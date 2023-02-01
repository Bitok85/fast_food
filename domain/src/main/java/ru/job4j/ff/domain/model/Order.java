package ru.job4j.ff.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @EqualsAndHashCode.Include
    private int id;

    private String address;

    private List<Dish> dishList;

    private Status status;

    private LocalDateTime created = LocalDateTime.now();
}
