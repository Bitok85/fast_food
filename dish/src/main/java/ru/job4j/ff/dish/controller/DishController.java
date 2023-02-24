package ru.job4j.ff.dish.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.ff.dish.service.StandardDishService;
import ru.job4j.ff.dish.dto.DishDTO;
import ru.job4j.ff.dish.dto.DishMapper;
import ru.job4j.ff.dish.util.exception.CheckBindResult;
import ru.job4j.ff.domain.model.Dish;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private StandardDishService dishService;

    private DishMapper dishMapper;


    @GetMapping("/{id}")
    public ResponseEntity<DishDTO> findDishById(@PathVariable ("id") int id) {
        Dish dish = dishService.findDishById(id);
        return new ResponseEntity<>(dishMapper.toDTO(dish), HttpStatus.OK);

    }

    @GetMapping("/{dishName}")
    public ResponseEntity<DishDTO> findDishByName(@PathVariable ("dishName") String dishName) {
        Dish dish = dishService.findDishByName(dishName);
        return new ResponseEntity<>(dishMapper.toDTO(dish), HttpStatus.OK);
    }

    @GetMapping
    public List<DishDTO> findAll() {
        return dishService.findAll().stream()
                .map(dish -> dishMapper.toDTO(dish))
                .collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<HttpStatus> addDish(@RequestBody @Valid DishDTO dishDTO,
                                              BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        dishService.addDish(dishMapper.toModel(dishDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<HttpStatus> deleteDish(@PathVariable ("name") String name) {
        dishService.deleteDish(name);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Dish> updateDish(@RequestBody @Valid DishDTO dishDTO,
                                           BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        Dish dish = dishService.updateDish(dishMapper.toModel(dishDTO));
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
}
