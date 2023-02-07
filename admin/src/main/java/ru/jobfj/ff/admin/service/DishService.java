package ru.jobfj.ff.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.dto.DishDTO;
import ru.job4j.ff.domain.model.Dish;
import ru.jobfj.ff.admin.repository.DishAPIRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishAPIRepository dishAPIRepository;

    public DishDTO addDish(DishDTO dishDTO) {
        return dishAPIRepository.addDish(dishDTO);
    }

    public DishDTO findDishByName(String name) {
        return dishAPIRepository.findDishByName(name);
    }


    public List<DishDTO> findAllDishes() {
        return dishAPIRepository.findAllDishes();
    }

    public boolean updateDish(DishDTO dishDTO) {
        return dishAPIRepository.updateDish(dishDTO);
    }

    public boolean deleteDish(String name) {
        return dishAPIRepository.deleteDish(name);
    }
}
