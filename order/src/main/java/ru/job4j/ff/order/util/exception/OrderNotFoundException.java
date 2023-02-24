package ru.job4j.ff.order.util.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
