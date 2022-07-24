package com.epam.mjc.demo.service;

import com.epam.mjc.demo.model.Discount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient("discount-service")
public interface DiscountClient {

    @RequestMapping("/discount")
    Discount getDiscount();
}
