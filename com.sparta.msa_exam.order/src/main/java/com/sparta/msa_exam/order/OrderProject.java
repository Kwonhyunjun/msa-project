package com.sparta.msa_exam.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderProject {

    @GetMapping("")
    public String test(){
        return "Order-Service";
    }

}
