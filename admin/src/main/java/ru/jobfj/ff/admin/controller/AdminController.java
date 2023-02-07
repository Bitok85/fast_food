package ru.jobfj.ff.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.ff.domain.dto.DishDTO;
import ru.job4j.ff.domain.exception.util.CheckBindResult;
import ru.jobfj.ff.admin.service.DishService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final DishService dishService;

    @GetMapping("/dishMain")
    public String dishes(Model model) {
        model.addAttribute("dishes", dishService.findAllDishes());
        return "dishMain";
    }

    @GetMapping("/photoDish/{dishName}")
    public ResponseEntity<Resource> download(@PathVariable("dishName") String dishName) {
        DishDTO dishDTO = dishService.findDishByName(dishName);
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(dishDTO.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(dishDTO.getPhoto()));
    }

    @GetMapping("/addDish")
    public String addDish(Model model) {
        model.addAttribute("dish", new DishDTO());
        return "addDish";
    }

    @PostMapping("/addDish")
    public String addDish(@ModelAttribute @Valid DishDTO dishDTO,
                          @RequestParam("file") MultipartFile file,
                          BindingResult bindingResult) throws IOException {
        dishDTO.setPhoto(file.getBytes());
        CheckBindResult.check(bindingResult);
        dishService.addDish(dishDTO);
        return "dishMain";
    }

    @DeleteMapping("/delete/{name}")
    public String deleteDish(@PathVariable ("name") String name) {
        dishService.deleteDish(name);
        return "dishMain";
    }

    @GetMapping("/formEditDish/{dishName}")
    public String editDish(Model model, @PathVariable ("dishName") String name) {
        model.addAttribute("dish", dishService.findDishByName(name));
        return "editDish";
    }

    @PostMapping("/editDish")
    public String editDish(@ModelAttribute DishDTO dishDTO,
                           @RequestParam("file") MultipartFile file,
                           BindingResult bindingResult) throws IOException {
        dishDTO.setPhoto(file.getBytes());
        CheckBindResult.check(bindingResult);
        dishService.updateDish(dishDTO);
        return "dishMain";
    }


}
