package com.sparta.msa_exam.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResDto {

    private Long orderId;
    private List<Long> productIds;

    public OrderResDto(Long id, List<Long> productIds) {
        this.orderId = id;
        this.productIds = productIds;
    }
}
