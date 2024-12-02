package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateResDto {

    private Long orderId;

    public OrderCreateResDto(Order order){
        this.orderId = order.getId();
    }
}
