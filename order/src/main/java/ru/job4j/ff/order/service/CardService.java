package ru.job4j.ff.order.service;

import org.springframework.stereotype.Service;
import ru.job4j.ff.domain.exception.CardNotFoundException;
import ru.job4j.ff.order.repository.CardRepository;
import ru.job4j.ff.domain.model.Card;
import ru.job4j.ff.domain.model.Customer;

@Service
public class CardService {

    private CardRepository cardRepository;

    public Card makeCard(Card card) {
        return cardRepository.save(card);
    }

    public Card findByCustomer(Customer customer) {
        return cardRepository.findByCustomer(customer).orElseThrow(
                () -> new CardNotFoundException("Customer has no cards")
        );
    }
}
