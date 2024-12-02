package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderCreateResDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderCreateResDto createOrder() {

        Order save = orderRepository.save(Order.create());

        return new OrderCreateResDto(save);
    }

}
