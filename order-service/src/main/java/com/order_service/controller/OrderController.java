package com.order_service.controller;

import com.order_service.dto.response.UserResponse;
import com.order_service.entity.Order;
import com.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        return orderService.getOrder(id);
    }

    @GetMapping("/users/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return orderService.getUser(userId);
    }

    @GetMapping("/users/instance")
    public String getUserInstance() {
        return orderService.getUserInstance();
    }
}
