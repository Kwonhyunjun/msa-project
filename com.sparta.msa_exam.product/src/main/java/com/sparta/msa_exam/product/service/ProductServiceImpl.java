package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import com.sparta.msa_exam.product.dto.ProductSearchResDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    @Transactional
    @CacheEvict(cacheNames = "productCache", allEntries = true)
    public void createProduct(ProductCreateReqDto productCreateReqDto) {

        productRepository.save(new Product(productCreateReqDto));

    }

    @Override
    @Cacheable(cacheNames = "productCache", key = "getMethodName()")
    public List<ProductSearchResDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductSearchResDto::new)
                .toList();
    }

}
