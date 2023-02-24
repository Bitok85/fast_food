package ru.job4j.ff.dish.service;

import org.springframework.stereotype.Service;
import ru.job4j.ff.dish.repository.DishRepository;
import ru.job4j.ff.dish.util.exception.DishNotFoundException;
import ru.job4j.ff.domain.model.Dish;

import java.util.List;

@Service
public class StandardDishService implements DishService {

    private DishRepository dishRepository;

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public Dish findDishById(int id) {
        return dishRepository.findById(id).orElseThrow(
                () -> new DishNotFoundException(
                        String.format("Dish %s not found", id)
                )
        );
    }

    @Override
    public Dish findDishByName(String name) {
        return dishRepository.findByName(name).orElseThrow(
                () -> new  DishNotFoundException(
                        String.format("Dish %s not found", name)
                )
        );
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public int cockingTime(String dishName) {
        return dishRepository.findByName(dishName).orElseThrow(
                () -> new DishNotFoundException(
                String.format("Dish %s not found", dishName)
        )
        ).getCockingTime();
    }

    @Override
    public boolean deleteDish(String name) {
        return dishRepository.deleteByName(name);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }
}
