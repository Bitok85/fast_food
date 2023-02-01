package ru.job4j.ff.domain.dto;

import lombok.Data;
import ru.job4j.ff.domain.model.Dish;
import ru.job4j.ff.domain.model.Status;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    @NotEmpty(message = "Address shouldn't be empty.")
    private String address;

    @NotEmpty(message = "Dish list shouldn't be empty ")
    private List<Dish> dishList;

    @NotEmpty(message = "Order should have status")
    private Status status;

    private LocalDateTime created = LocalDateTime.now();
}
