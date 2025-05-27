package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-discount-coupon", url = "https://localhost:9012/api/discount-coupons")
public interface DiscountCouponClient {
    @GetMapping("/{id}")
    Object getDiscountCouponById(@PathVariable("id") String id);
}
