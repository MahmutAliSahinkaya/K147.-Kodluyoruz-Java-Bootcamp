package com.emlakcepte.service;

import com.emlakcepte.converter.PaymentConverter;
import com.emlakcepte.model.Payment;
import com.emlakcepte.repository.PaymentRepository;
import com.emlakcepte.request.PaymentRequest;
import com.emlakcepte.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentConverter paymentConverter;

    public PaymentResponse add(PaymentRequest paymentRequest) {
        Payment payment = paymentConverter.convert(paymentRequest);
        log.info("Payment has been success.");
        Payment savedPayment = paymentRepository.save(payment);
        return paymentConverter.convert(savedPayment);
    }

}
