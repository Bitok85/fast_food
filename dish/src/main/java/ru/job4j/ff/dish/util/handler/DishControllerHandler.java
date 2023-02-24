package ru.job4j.ff.dish.util.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.job4j.ff.dish.util.exception.DishErrorResponse;
import ru.job4j.ff.dish.util.exception.DishNotFoundException;

@RestControllerAdvice(annotations = RestController.class)
public class DishControllerHandler {

    @ExceptionHandler
    public ResponseEntity<DishErrorResponse> handleDishNotFoundException(DishNotFoundException exception) {
        DishErrorResponse dishErrorResponse = new DishErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(dishErrorResponse, HttpStatus.NOT_FOUND);
    }
}
