package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.ff.order.dto.CardDTO;
import ru.job4j.ff.order.util.exception.CheckBindResult;
import ru.job4j.ff.order.dto.CardMapper;
import ru.job4j.ff.order.service.CardService;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    private final CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<HttpStatus> makeCard(@RequestBody @Valid CardDTO cardDTO,
                                               BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        cardService.makeCard(cardMapper.toModel(cardDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
