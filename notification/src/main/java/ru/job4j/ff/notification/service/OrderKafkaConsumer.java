package ru.job4j.ff.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Notification;
import ru.job4j.ff.domain.model.Order;

@Service
@RequiredArgsConstructor
public class OrderKafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "newOrder", groupId = "fastFood")
    public void consumeOrderAndCreateNotification(Order order) {
        Notification notification = Notification.builder()
                .orderNumber(order.getId())
                .status("Принят")
                .message(
                        String.format(
                                "Ваш заказ %s принят, сумма к оплате %s",
                                order.getId(),
                                order.getAmount()
                        )
                )
                .orderCreatedAt(order.getCreatedAt())
                .build();
        notificationService.saveNotification(notification);
    }
}
