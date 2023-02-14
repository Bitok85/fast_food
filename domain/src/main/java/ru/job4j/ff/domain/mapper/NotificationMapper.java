package ru.job4j.ff.domain.mapper;

import org.mapstruct.Mapper;
import ru.job4j.ff.domain.dto.NotificationDTO;
import ru.job4j.ff.domain.model.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDTO toDTO(Notification notification);

    Notification toModel(NotificationDTO notificationDTO);
}
