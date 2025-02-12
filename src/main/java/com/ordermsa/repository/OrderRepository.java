package com.ordermsa.repository;

import com.ordermsa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(String orderId);
    Iterable<OrderEntity> findByUserId(String userId);
}
