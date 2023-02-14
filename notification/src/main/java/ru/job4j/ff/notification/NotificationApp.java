package ru.job4j.ff.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.job4j.ff.domain", "ru.job4j.ff.notification"})
@EntityScan(basePackages = {"ru.job4j.ff.domain.model"})
public class NotificationApp {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class);
    }
}
