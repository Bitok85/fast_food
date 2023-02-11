package ru.job4j.ff.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotEmpty
    private String authority;

    @ToString.Exclude
    @OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

}
