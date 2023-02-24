package ru.job4j.ff.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.model.Card;
import ru.job4j.ff.order.repository.CardRepository;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card makeCard(Card card) {
        return cardRepository.save(card);
    }

}
