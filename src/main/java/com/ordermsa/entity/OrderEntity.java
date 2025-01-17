package com.ordermsa.entity;

import com.ordermsa.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    @CreatedDate
    private Date createdAt;

    public OrderEntity(OrderDTO dto) {
        productId = dto.getProductId();
        qty = dto.getQty();
        unitPrice = dto.getUnitPrice();
        totalPrice = dto.getTotalPrice();
        userId = dto.getUserId();
        orderId = dto.getOrderId();
    }
}
