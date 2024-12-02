package com.sparta.msa_exam.product.entity;

import com.sparta.msa_exam.product.dto.ProductCreateReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "supply_price")
    private Integer supplyPrice;

    public Product(ProductCreateReqDto productCreateReqDto){
        this.name = productCreateReqDto.getName();
        this.supplyPrice = productCreateReqDto.getSupplyPrice();
    }
}
