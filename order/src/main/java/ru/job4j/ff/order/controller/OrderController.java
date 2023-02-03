package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.ff.order.service.OrderService;
import ru.job4j.ff.domain.dto.OrderDTO;
import ru.job4j.ff.domain.model.Customer;
import ru.job4j.ff.domain.model.Order;
import ru.job4j.ff.order.util.CheckBindResult;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") int id) {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(convertToOrderDTO(order), HttpStatus.OK);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> orderReadiness(@PathVariable("id") int id) {
        boolean status = orderService.orderReadiness(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping
    public List<OrderDTO> findAllByCustomer(@RequestBody @Valid Customer customer) {
        return orderService.findAllByCustomer(customer).stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<HttpStatus> createOrder(@RequestBody @Valid OrderDTO orderDTO,
                                                  BindingResult bindingResult) {
        CheckBindResult.check(bindingResult);
        orderService.createOrder(convertToOrder(orderDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    private Order convertToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }
}
