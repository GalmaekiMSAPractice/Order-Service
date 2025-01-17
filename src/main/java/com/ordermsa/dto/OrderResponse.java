package com.ordermsa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ordermsa.entity.OrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class OrderResponse {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;
    private String orderId;

    public OrderResponse(OrderDTO dto) {
        this.productId = dto.getProductId();
        this.qty = dto.getQty();
        this.unitPrice = dto.getUnitPrice();
        this.totalPrice = dto.getTotalPrice();
        this.orderId = dto.getOrderId();
    }

    public OrderResponse(OrderEntity entity) {
        this.productId = entity.getProductId();
        this.qty = entity.getQty();
        this.unitPrice = entity.getUnitPrice();
        this.totalPrice = entity.getTotalPrice();
        this.createdAt = entity.getCreatedAt();
        this.orderId = entity.getOrderId();
    }
}
