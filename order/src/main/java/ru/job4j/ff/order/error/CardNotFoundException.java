package ru.job4j.ff.order.error;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String msg) {
        super(msg);
    }
}
