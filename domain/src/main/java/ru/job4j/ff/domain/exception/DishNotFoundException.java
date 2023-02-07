package ru.job4j.ff.domain.exception;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException(String message) {
        super(message);
    }
}
