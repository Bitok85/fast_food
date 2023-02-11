package ru.job4j.ff.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class NotificationDTO {

    private int orderNumber;

    @NotEmpty
    @Size(min = 2, max = 30, message = "Status should be between 2 and 30 characters")
    private String status;

    private String message;
}
