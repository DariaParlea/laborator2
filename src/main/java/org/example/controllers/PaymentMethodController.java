package org.example.controllers;

import org.example.main.PaymentMethod;
import org.example.repositories.PaymentMethodRepository;

import java.util.List;


public class PaymentMethodController {
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodController(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void createPaymentMethod(int paymentId, String type, String status) {
        PaymentMethod paymentMethod = new PaymentMethod(paymentId, type, status);
        paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod findPaymentMethodById(int paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId);
    }

    public List<PaymentMethod> viewAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public void updatePaymentMethod(int paymentMethodId, String type, String status) {
        PaymentMethod updatedPaymentMethod = new PaymentMethod(paymentMethodId, type, status);
        paymentMethodRepository.update(updatedPaymentMethod);
    }

    public void deletePaymentMethod(int paymentMethodId) {
        paymentMethodRepository.delete(paymentMethodId);
    }


}
