package com.order_service.service;

import com.order_service.config.UserFeignClient;
import com.order_service.dto.response.UserResponse;
import com.order_service.entity.Order;
import com.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserFeignClient userFeignClient;

    public OrderService(OrderRepository orderRepository, UserFeignClient userFeignClient) {
        this.orderRepository = orderRepository;
        this.userFeignClient = userFeignClient;
    }

    public Order createOrder(Order order) {

        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found: " + id));
    }

    public UserResponse getUser(Long userId) {
        return userFeignClient.getUser(userId);
    }

    public String getUserInstance() {
        return userFeignClient.getUserInstance();
    }

}
