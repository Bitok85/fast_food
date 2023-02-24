package ru.job4j.ff.order.util.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.job4j.ff.order.util.exception.CardErrorResponse;
import ru.job4j.ff.order.util.exception.CardNotFoundException;
import ru.job4j.ff.order.util.exception.OrderErrorResponse;
import ru.job4j.ff.order.util.exception.OrderNotFoundException;

@RestControllerAdvice(annotations = RestController.class)
public class OrderControllerHandler {

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
