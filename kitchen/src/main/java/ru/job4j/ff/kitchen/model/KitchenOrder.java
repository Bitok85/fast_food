package ru.job4j.ff.kitchen.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.job4j.ff.domain.model.Dish;
import ru.job4j.ff.domain.model.Status;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "kitchen")
public class KitchenOrder {

    @Id
    @EqualsAndHashCode.Include
    private int id;

    private List<Dish> dishes;

    private Status status;


}
