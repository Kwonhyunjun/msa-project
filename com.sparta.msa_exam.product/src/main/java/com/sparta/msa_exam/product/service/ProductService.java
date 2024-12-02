package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import com.sparta.msa_exam.product.dto.ProductSearchResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    void createProduct(ProductCreateReqDto productCreateReqDto);

    Page<ProductSearchResDto> searchProduct(Pageable pageable);
}
