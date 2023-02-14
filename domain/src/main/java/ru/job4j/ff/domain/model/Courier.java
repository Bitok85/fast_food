package ru.job4j.ff.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "name_")
    private String name;

    private String surname;

    @Column(name = "phone_number")
    @Pattern(regexp = "(\\+7|0)[0-9]{9}")
    private int phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courier")
    private Set<Order> orders = new HashSet<>();

}
