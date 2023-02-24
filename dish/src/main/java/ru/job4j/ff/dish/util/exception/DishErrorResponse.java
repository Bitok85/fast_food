package ru.job4j.ff.dish.util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishErrorResponse {

    private String message;
    private long timestamp;

}
