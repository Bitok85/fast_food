package ru.job4j.ff.domain.mapper;

import org.mapstruct.Mapper;
import ru.job4j.ff.domain.dto.CardDTO;
import ru.job4j.ff.domain.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDTO toDTO(Card card);

    Card toModel(CardDTO cardDTO);
}
