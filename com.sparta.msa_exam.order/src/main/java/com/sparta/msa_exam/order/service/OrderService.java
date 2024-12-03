package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderCreateResDto;
import com.sparta.msa_exam.order.dto.OrderResDto;
import com.sparta.msa_exam.order.dto.ProductAddReqDto;

public interface OrderService {
    OrderCreateResDto createOrder();

    void addProduct(Long orderId, ProductAddReqDto productAddReqDto);

    OrderResDto getOrder(Long orderId);
}
