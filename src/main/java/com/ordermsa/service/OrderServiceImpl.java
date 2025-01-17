package com.ordermsa.service;

import com.ordermsa.dto.OrderDTO;
import com.ordermsa.entity.OrderEntity;
import com.ordermsa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDetail) {
        orderDetail.setOrderId(UUID.randomUUID().toString());
        orderDetail.setTotalPrice(orderDetail.getQty() * orderDetail.getUnitPrice());

        OrderEntity order = new OrderEntity(orderDetail);

        orderRepository.save(order);

        return new OrderDTO(order);
    }

    @Override
    public OrderDTO getOrderByOrderId(String orderId) {
        return new OrderDTO(
                orderRepository.findByOrderId(orderId)
        );
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
