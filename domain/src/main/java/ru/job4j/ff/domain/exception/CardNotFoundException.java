package ru.job4j.ff.domain.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String msg) {
        super(msg);
    }
}
