package ru.job4j.ff.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
public class CourierDTO {

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Surname shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String surname;

    @NotEmpty(message = "Phone number shouldn't be empty")
    @Pattern(regexp = "(\\+7|0)[0-9]{9}")
    private int phoneNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<OrderDTO> orderDTOs = new HashSet<>();
}
