package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.dto.OrderCreateResDto;
import com.sparta.msa_exam.order.dto.ProductAddReqDto;
import com.sparta.msa_exam.order.dto.ProductResDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.exception.CustomException;
import com.sparta.msa_exam.order.exception.ExceptionType;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductClient productClient;

    @Override
    @Transactional
    public OrderCreateResDto createOrder() {

        Order save = orderRepository.save(Order.create());

        return new OrderCreateResDto(save);
    }

    @Override
    @Transactional
    public void addProduct(Long orderId, ProductAddReqDto productAddReqDto) {
        List<ProductResDto> list = getProducts();

        for(ProductResDto productResDto : list){
            log.info("id : {}", productResDto.getProductId());
            log.info("name : {}", productResDto.getName());
            log.info("price : {}", productResDto.getSupplyPrice());

            if(Objects.equals(productResDto.getProductId(), productAddReqDto.getProductId())){
                Order order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException(ExceptionType.ORDER_NOT_FOUND));
                orderProductRepository.save(new OrderProduct(order, productResDto.getProductId()));
                break;
            }
        }

        throw new CustomException(ExceptionType.PRODUCT_NOT_MATCH);
    }

    public List<ProductResDto> getProducts() { return productClient.getProducts(); }
}
