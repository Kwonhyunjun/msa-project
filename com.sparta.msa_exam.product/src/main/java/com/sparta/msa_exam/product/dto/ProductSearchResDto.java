package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchResDto {

    private Long productId;
    private String name;
    private Integer supplyPrice;

    public ProductSearchResDto(Product product){
        this.productId = product.getProductId();
        this.name = product.getName();
        this.supplyPrice = product.getSupplyPrice();
    }

}
