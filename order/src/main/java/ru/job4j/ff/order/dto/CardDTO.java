package ru.job4j.ff.order.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ru.job4j.ff.domain.model.Customer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CardDTO {

    @EqualsAndHashCode.Include
    @NotEmpty
    @Min(value = 5, message = "Discount couldn't be less then 5%")
    private int bonus;

    @NotEmpty
    private Date beginsAt;

    @NotEmpty
    private Date expiresAt;

}
