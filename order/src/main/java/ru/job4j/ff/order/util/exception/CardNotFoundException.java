package ru.job4j.ff.order.util.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String msg) {
        super(msg);
    }
}
