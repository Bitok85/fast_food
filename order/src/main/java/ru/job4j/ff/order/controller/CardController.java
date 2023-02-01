package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.ff.domain.dto.CardDTO;
import ru.job4j.ff.domain.model.Card;
import ru.job4j.ff.order.error.CardCreationException;
import ru.job4j.ff.order.service.CardService;
import ru.job4j.ff.order.util.CheckBindResult;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private CardService cardService;

    private ModelMapper modelMapper;

    @GetMapping

    @PostMapping
    public ResponseEntity<HttpStatus> makeCard(@RequestBody @Valid CardDTO cardDTO,
                                               BindingResult bindingResult) {
        String errorMsg = CheckBindResult.check(bindingResult);
        if (!errorMsg.isEmpty()) {
            throw new CardCreationException(errorMsg);
        }
        cardService.makeCard(convertToCard(cardDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private CardDTO convertToCardDTO(Card card) {
        return modelMapper.map(card, CardDTO.class);
    }

    private Card convertToCard(CardDTO cardDTO) {
        return modelMapper.map(cardDTO, Card.class);
    }
}
