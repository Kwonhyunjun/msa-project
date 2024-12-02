package com.sparta.msa_exam.order.client;

import com.sparta.msa_exam.order.dto.ProductResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductResDto> getProducts();

}
