package ru.job4j.ff.order.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.job4j.ff.delivery.dto.CourierDTO;
import ru.job4j.ff.dish.dto.DishDTO;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.customer.dto.CustomerDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
