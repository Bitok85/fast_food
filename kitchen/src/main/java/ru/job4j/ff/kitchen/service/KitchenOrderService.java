package ru.job4j.ff.kitchen.service;

import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.kitchen.model.KitchenOrder;
import ru.job4j.ff.kitchen.repository.KitchenOrderRepository;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderService {

    private final KitchenOrderRepository store;
    private final KitchenKafkaConsumer kitchenKafkaConsumer;

    private final KafkaOrderProducer kafkaOrderProducer;

   
    public void createKitchenOrderAndSendItBackToOrderService(Order order) {
        try {
            KitchenOrder kitchenOrder = orderToKitchenOrder(
                    kitchenKafkaConsumer.consumePreorder(order)
            );
            addKitchenOrder(kitchenOrder);
            pause();
            order.setStatus(findById(kitchenOrder.getId()).getStatus());
            kafkaOrderProducer.sendCookedOrder(order);
        } catch (Exception e) {
            order.setStatus(Status.CANCELED);
            kafkaOrderProducer.sendCookedOrder(order);
            log.error("Ошибка при работе с заказом", e);
        }
    }

    public void addKitchenOrder(KitchenOrder kitchenOrder) {
        store.save(kitchenOrder);
    }

    public KitchenOrder findById(int id) {
        return store.findById(id).orElseThrow(
                () -> new MongoException(
                        String.format("Order with id %s not found!", id)
                )
        );
    }

    private KitchenOrder orderToKitchenOrder(Order order) {
        KitchenOrder kitchenOrder = new KitchenOrder();
        kitchenOrder.setId(order.getId());
        kitchenOrder.setDishes(new ArrayList<>(order.getDishList()));
        return kitchenOrder;
    }

    private void pause() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
