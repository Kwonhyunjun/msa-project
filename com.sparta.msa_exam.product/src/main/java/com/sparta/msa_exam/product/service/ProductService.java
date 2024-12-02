package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import com.sparta.msa_exam.product.dto.ProductSearchResDto;

import java.util.List;

public interface ProductService {

    void createProduct(ProductCreateReqDto productCreateReqDto);

    List<ProductSearchResDto> getProducts();
}
