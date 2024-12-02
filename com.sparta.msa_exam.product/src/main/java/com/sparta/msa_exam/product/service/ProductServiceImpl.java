package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import com.sparta.msa_exam.product.dto.ProductSearchResDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(ProductCreateReqDto productCreateReqDto) {

        productRepository.save(new Product(productCreateReqDto));

    }

    @Override
    public Page<ProductSearchResDto> searchProduct(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductSearchResDto::new);
    }

}
