package ru.job4j.ff.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;
    private String type;
    private String description;
    private float price;

    @Column(name = "cocking_time")
    private int cockingTime;

    private byte[] photo;
    private boolean availability;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dishes_orders",
            joinColumns = { @JoinColumn(name = "dish_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Order> orders = new HashSet<>();

}
