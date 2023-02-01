package ru.job4j.ff.order.error;

public class OrderCreationException extends RuntimeException {

    public OrderCreationException(String message) {
        super(message);
    }
}
