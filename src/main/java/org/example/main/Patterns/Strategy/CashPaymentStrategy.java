package org.example.main.Patterns.Strategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}