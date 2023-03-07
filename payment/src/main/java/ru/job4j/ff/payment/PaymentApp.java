package ru.job4j.ff.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.ff.domain", "ru.job4j.ff.payment"})
@EntityScan(basePackages = {"ru.job4j.ff.domain.model"})
public class PaymentApp {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class);
    }
}
