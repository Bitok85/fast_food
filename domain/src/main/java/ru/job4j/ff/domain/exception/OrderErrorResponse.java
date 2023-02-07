package ru.job4j.ff.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderErrorResponse {

    private String message;
    private long timestamp;
}
