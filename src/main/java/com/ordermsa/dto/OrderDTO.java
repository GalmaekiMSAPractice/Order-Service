package com.ordermsa.dto;

import com.ordermsa.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public OrderDTO(OrderEntity orderEntity) {
        this.productId = orderEntity.getProductId();
        this.qty = orderEntity.getQty();
        this.unitPrice = orderEntity.getUnitPrice();
        this.totalPrice = orderEntity.getTotalPrice();
        this.orderId = orderEntity.getOrderId();
        this.userId = orderEntity.getUserId();
    }

    public OrderDTO(OrderRequest orderRequest) {
        this.productId = orderRequest.getProductId();
        this.qty = orderRequest.getQty();
        this.unitPrice = orderRequest.getUnitPrice();
        this.totalPrice = orderRequest.getTotalPrice();
        this.orderId = orderRequest.getOrderId();
        this.userId = orderRequest.getUserId();
    }
}
