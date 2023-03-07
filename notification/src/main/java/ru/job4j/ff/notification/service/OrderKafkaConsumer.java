package ru.job4j.ff.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Notification;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;

@Service
@RequiredArgsConstructor
public class OrderKafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notificationOrder", groupId = "fastFood")
    public void consumeOrderAndCreateNotification(Order order) {
        Notification notification = Notification.builder()
                .orderNumber(order.getId())
                .status(order.getStatus().toString())
                .message(checkOrderStatus(order))
                .orderCreatedAt(order.getCreatedAt())
                .build();
        notificationService.saveNotification(notification);
    }

    private String checkOrderStatus(Order order) {
        if (order.getStatus().equals(Status.CANCELED)) {
            return String.format(
                    "По какой-то причине мы не можем выполнить Ваш заказ %s,"
                            + "в ближайшее время наш менеджер с Вами свяжется", order.getId()
            );
        }
        return String.format(
                "Ваш заказ %s принят, сумма к оплате %s",
                order.getId(),
                order.getAmount()
        );
    }
}
