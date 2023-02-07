package ru.job4j.ff.domain.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
