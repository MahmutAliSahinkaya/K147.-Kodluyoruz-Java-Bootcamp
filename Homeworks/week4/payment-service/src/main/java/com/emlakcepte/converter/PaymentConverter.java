package com.emlakcepte.converter;

import com.emlakcepte.model.Payment;
import com.emlakcepte.request.PaymentRequest;
import com.emlakcepte.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {
    private Long orderNo = 98765432L;

    public PaymentResponse convert(Payment payment) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOrderNo(payment.getOrderNo());
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setIsPay(payment.getIsPay());
        paymentResponse.setProductId(payment.getProductId());
        paymentResponse.setUserId(payment.getUserId());
        return paymentResponse;
    }

    public Payment convert(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setOrderNo(orderNo++);
        payment.setIsPay(paymentRequest.getIsPay());
        payment.setUserId(paymentRequest.getUserId());
        payment.setProductId(paymentRequest.getProductId());
        payment.setAmount(paymentRequest.getAmount());
        return payment;
    }

}
