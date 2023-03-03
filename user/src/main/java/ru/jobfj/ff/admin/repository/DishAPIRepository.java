package ru.jobfj.ff.admin.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.ff.dish.dto.DishDTO;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DishAPIRepository {

    private final RestTemplate restTemplate;

    @Value("{dishes.api.url}")
    private String url;

    public DishDTO addDish(DishDTO dishDTO) {
        return restTemplate.postForEntity(url, dishDTO, DishDTO.class).getBody();
    }

    public DishDTO findDishByName(String name) {
        return restTemplate.getForEntity(
                String.format("%s/%d", url, name), DishDTO.class
        ).getBody();
    }

    public List<DishDTO> findAllDishes() {
        List<DishDTO> body = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DishDTO>>() {
                }).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    public boolean updateDish(DishDTO dishDTO) {
        return restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(dishDTO),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean deleteDish(String name) {
        return restTemplate.exchange(
                String.format("%s/%d", url, name),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }



}
