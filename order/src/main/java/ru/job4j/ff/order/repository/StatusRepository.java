package ru.job4j.ff.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.ff.domain.model.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
