package ru.job4j.ff.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DishDTO {

    @EqualsAndHashCode.Include
    @NotEmpty(message = "Name shouldn't be empty.")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Type shouldn't be empty.")
    private String type;

    @NotEmpty (message = "Type shouldn't be empty.")
    @Size(min = 10, max = 200, message = "Description should be between 10 and 200 characters")
    private String description;

    @Min(value = 0, message = "Price can't be less 0")
    private float price;

    @Min(value = 0, message = "Cocking time can't be less 0 minutes")
    private int cockingTime;

    private byte[] photo;

    @NotEmpty
    private boolean availability;

    private List<String> availabilities = List.of("Есть в наличии", "Нет в наличии");

}
