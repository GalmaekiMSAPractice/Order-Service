package com.ordermsa.controller;


import com.ordermsa.dto.OrderDTO;
import com.ordermsa.dto.OrderRequest;
import com.ordermsa.dto.OrderResponse;
import com.ordermsa.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/order-service")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/healthcheck")
    public String status() {
        return "Working Now";
    }

    @PostMapping("/{userId}/orders")
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
