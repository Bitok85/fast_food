package ru.job4j.ff.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.ff.domain", "ru.job4j.ff.kitchen"})
@EntityScan(basePackages = {"ru.job4j.ff.domain.model"})
public class KitchenApp {

    public static void main(String[] args) {
        SpringApplication.run(KitchenApp.class);
    }
}
