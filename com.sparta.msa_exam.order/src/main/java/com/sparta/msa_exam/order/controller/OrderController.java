package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderCreateResDto;
import com.sparta.msa_exam.order.dto.ProductAddReqDto;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<OrderCreateResDto> createOrder(){

        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder());
    }

    @PutMapping("/{orderId}")
    public ResponseEntity addProduct(
            @PathVariable Long orderId,
            @RequestBody ProductAddReqDto productAddReqDto
        ){

        log.info("orderId : {}", orderId);
        log.info("productId : {}", productAddReqDto.getProductId());

        orderService.addProduct(orderId, productAddReqDto);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(
            @PathVariable(name = "orderId") Long orderId
    ){

        log.info("orderId : {}", orderId);

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(orderId));
    }
}
