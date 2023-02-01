package ru.job4j.ff.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Status {

    @EqualsAndHashCode.Include
    private int id;

    private boolean readiness;

}
