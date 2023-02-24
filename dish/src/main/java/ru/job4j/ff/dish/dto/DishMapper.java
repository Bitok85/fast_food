package ru.job4j.ff.dish.dto;

import org.mapstruct.Mapper;
import ru.job4j.ff.domain.model.Dish;

@Mapper(componentModel = "spring")
public interface DishMapper {

    DishDTO toDTO(Dish dish);

    Dish toModel(DishDTO dishDTO);
}
