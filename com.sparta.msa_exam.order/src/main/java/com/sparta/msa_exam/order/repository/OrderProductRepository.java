package com.sparta.msa_exam.order.repository;

import com.sparta.msa_exam.order.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    List<OrderProduct> findAllByOrderIdOrderByProductId(Long orderId);
}
