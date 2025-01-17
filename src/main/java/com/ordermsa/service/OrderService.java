package com.ordermsa.service;

import com.ordermsa.dto.OrderDTO;
import com.ordermsa.entity.OrderEntity;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDetail);
    OrderDTO getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
