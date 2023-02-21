package com.emlakcepte.client;

import com.emlakcepte.request.PaymentRequest;
import com.emlakcepte.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-feign", url = "http://localhost:8084/payments")
public interface PaymentClient {
    @PostMapping(value = "/payments")
    PaymentResponse add(@RequestBody PaymentRequest paymentRequest);

}
