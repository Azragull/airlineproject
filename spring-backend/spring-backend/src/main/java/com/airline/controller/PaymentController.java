package com.airline.controller;

import com.airline.model.Payment;
import com.airline.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Integer id, @RequestBody Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setAmount(updatedPayment.getAmount());
                    payment.setStatus(updatedPayment.getStatus());
                    payment.setPaymentMethod(updatedPayment.getPaymentMethod());
                    return paymentRepository.save(payment);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Integer id) {
        paymentRepository.deleteById(id);
    }
}
