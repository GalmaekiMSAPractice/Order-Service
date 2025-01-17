package com.ordermsa.controller;


import com.ordermsa.dto.OrderDTO;
import com.ordermsa.dto.OrderRequest;
import com.ordermsa.dto.OrderResponse;
import com.ordermsa.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{userId]/orders")
    public ResponseEntity<OrderResponse> createOrder(@PathVariable String userId, @RequestBody OrderRequest orderRequest) {
        OrderDTO dto = new OrderDTO(orderRequest);
        dto.setUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new OrderResponse(orderService.createOrder(dto))
        );
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderResponse>> getOrder(@PathVariable String userId) {
        List<OrderResponse> list = new ArrayList<>();
        orderService.getOrdersByUserId(userId).forEach(v -> list.add(new OrderResponse(v)));
        return ResponseEntity.ok(
                list
        );
    }
}
