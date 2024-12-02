package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import com.sparta.msa_exam.product.dto.ProductSearchResDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity createProduct(@RequestBody ProductCreateReqDto productCreateReqDto){

        log.info("productName : {}", productCreateReqDto.getName());
        log.info("productPrice : {}", productCreateReqDto.getSupplyPrice());

        productService.createProduct(productCreateReqDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("")
    public ResponseEntity<Page<ProductSearchResDto>> searchProduct(
        Pageable pageable
    ){
        log.info("page : {}", pageable.getPageNumber());
        log.info("size : {}", pageable.getPageSize());

        return ResponseEntity.status(HttpStatus.OK).body(productService.searchProduct(pageable));
    }
}
