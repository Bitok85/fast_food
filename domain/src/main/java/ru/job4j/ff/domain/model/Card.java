package ru.job4j.ff.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {

    @EqualsAndHashCode.Include
    private int id;

    private int bonus;

    private Customer customer;
}
