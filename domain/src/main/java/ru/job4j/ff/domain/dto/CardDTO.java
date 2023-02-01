package ru.job4j.ff.domain.dto;

import lombok.Data;
import ru.job4j.ff.domain.model.Customer;

import javax.validation.constraints.Min;

@Data
public class CardDTO {

    @Min(value = 0, message = "Bonus should be greater then 0")
    private int bonus;

    private Customer customer;
}
