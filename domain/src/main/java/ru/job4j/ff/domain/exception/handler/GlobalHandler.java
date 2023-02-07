package ru.job4j.ff.domain.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.job4j.ff.domain.exception.*;

@RestControllerAdvice(annotations = RestController.class)
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

    @ExceptionHandler
    public ResponseEntity<DishErrorResponse> handleDishNotFoundException(DishNotFoundException exception) {
        DishErrorResponse dishErrorResponse = new DishErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(dishErrorResponse, HttpStatus.NOT_FOUND);
    }
}
