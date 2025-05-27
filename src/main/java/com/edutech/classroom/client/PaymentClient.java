package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-payment", url = "https://localhost:9013/api/payments")
public interface PaymentClient {
    @GetMapping("/{id}")
    Object getPaymentById(@PathVariable("id") String id);
}
