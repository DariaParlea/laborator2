package org.example.repositories;



import org.example.model.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepository {

    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public PaymentMethod findById(int targetPaymentId) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod.getPayment_id() == targetPaymentId) {
                return paymentMethod;
            }
        }
        return null;
    }

    public List<PaymentMethod> findAll() {
        return paymentMethods;
    }

    public void save(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    public void update(PaymentMethod updatedPaymentMethod) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod.getPayment_id() == updatedPaymentMethod.getPayment_id()) {
                paymentMethod.setType(updatedPaymentMethod.getType());
                paymentMethod.setStatus(updatedPaymentMethod.getStatus());
                break;
            }
        }
    }

    public void delete(int targetPaymentId) {
        PaymentMethod paymentMethodToRemove = null;
        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod.getPayment_id() == targetPaymentId) {
                paymentMethodToRemove = paymentMethod;
                break;
            }
        }
        if (paymentMethodToRemove != null) {
            paymentMethods.remove(paymentMethodToRemove);
        }
    }
}
