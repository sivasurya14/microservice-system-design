package com.payment.controller;


import com.payment.entity.Payment;
import com.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/status")
    public String getPaymentStatus() {
        return "Payment service is running.";

    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {

        return paymentService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {

        return paymentService.getPayment(id);
    }

}
