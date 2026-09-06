package com.order_service.config;

import com.order_service.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    UserResponse getUser(@PathVariable("id") Long id);

    @GetMapping("/users/instance")
    String getUserInstance();
}
