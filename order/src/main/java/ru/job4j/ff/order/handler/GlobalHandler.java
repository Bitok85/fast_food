package ru.job4j.ff.order.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.job4j.ff.order.error.CardErrorResponse;
import ru.job4j.ff.order.error.CardNotFoundException;
import ru.job4j.ff.order.error.OrderErrorResponse;
import ru.job4j.ff.order.error.OrderNotFoundException;

@RestControllerAdvice(basePackages = "ru.job4j.ff.order.controller")
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<OrderErrorResponse> handleOrderNotFoundException(OrderNotFoundException exception) {
        OrderErrorResponse orderErrorResponse = new OrderErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(orderErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleCardNotFoundException(CardNotFoundException exception) {
        CardErrorResponse cardErrorResponse = new CardErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(cardErrorResponse, HttpStatus.NOT_FOUND);
    }
}
