package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.ff.domain.dto.CardDTO;
import ru.job4j.ff.domain.mapper.CardMapper;
import ru.job4j.ff.domain.model.Card;
import ru.job4j.ff.order.service.CardService;
import ru.job4j.ff.domain.exception.util.CheckBindResult;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private CardService cardService;

    private CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<HttpStatus> makeCard(@RequestBody @Valid CardDTO cardDTO,
                                               BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        cardService.makeCard(cardMapper.toModel(cardDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
