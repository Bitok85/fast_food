package ru.job4j.ff.domain.dto;

import lombok.*;

import ru.job4j.ff.domain.model.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDTO {

    private int id;

    @Min(value = 0, message = "Order amount couldn't be less then null")
    private float amount;

    @EqualsAndHashCode.Include
    @NotEmpty(message = "Address shouldn't be empty.")
    private String address;

    @ToString.Exclude
    @NotEmpty(message = "Dish list shouldn't be empty ")
    private List<DishDTO> dishList;

    @EqualsAndHashCode.Include
    @NotNull
    private CustomerDTO customerDTO;

    private CourierDTO courierDTO;

    @NotNull
    private Status status;

    private CardDTO cardDTO;

    private LocalDateTime createdAt;
}
