package ru.job4j.ff.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String surName;

    private int age;

    private String email;

    private String phoneNumber;
}
