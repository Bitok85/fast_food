package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.ff.domain.dto.OrderDTO;
import ru.job4j.ff.domain.exception.util.CheckBindResult;
import ru.job4j.ff.domain.mapper.OrderMapper;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.domain.model.Status;
import ru.job4j.ff.order.service.OrderKafkaProducer;
import ru.job4j.ff.order.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    private final OrderKafkaProducer orderKafkaProducer;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") int id) {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.OK);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Status> orderStatus(@PathVariable("id") int id) {
        Status status = orderService.orderStatus(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping
    public List<OrderDTO> findAllByCustomer(@RequestBody @Valid Customer customer) {
        return orderService.findAllByCustomer(customer).stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<HttpStatus> createOrder(@RequestBody @Valid OrderDTO orderDTO,
                                                  BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        Order order = orderMapper.toModel(orderDTO);
        orderService.createOrder(order);
        orderKafkaProducer.sendOrder(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
