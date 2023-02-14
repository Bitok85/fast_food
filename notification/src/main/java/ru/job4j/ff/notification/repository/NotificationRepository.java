package ru.job4j.ff.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.ff.domain.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {
}
