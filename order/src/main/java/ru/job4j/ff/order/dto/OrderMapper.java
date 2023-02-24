package ru.job4j.ff.order.dto;

import org.mapstruct.Mapper;
import ru.job4j.ff.domain.model.Order;

@Mapper(componentModel = "spring")

public interface OrderMapper {

    OrderDTO toDTO(Order order);

    Order toModel(OrderDTO orderDTO);
}
