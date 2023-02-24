package ru.job4j.ff.dish.util.exception;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException(String message) {
        super(message);
    }
}
