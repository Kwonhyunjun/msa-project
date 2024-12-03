package com.sparta.msa_exam.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderProductResDto {

    List<Long> productIds;
}
