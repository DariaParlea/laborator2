package org.example.tests;
import org.example.main.Orders;
import org.example.repositories.OrdersRepository;
import org.example.repositories.PaymentMethodRepository;
import org.example.main.PaymentMethod;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PaymentMethodRepositoryTest {

    @Test
    void findByIdTest_expected() {
        PaymentMethod paymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethod);
        PaymentMethod foundPaymentMethod = paymentMethodRepository.findById(1);
        assertEquals(paymentMethod, foundPaymentMethod, "Failed to find payment method by Id");
    }

    @Test
    void findByIdTest_unexpected() {
        PaymentMethod paymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethod);
        PaymentMethod foundPaymentMethod = paymentMethodRepository.findById(2);
        assertNull(foundPaymentMethod, "Found unexpected payment method by Id");
    }

    @Test
    void findAllTest_expected() {
        PaymentMethod paymentMethod1 = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethod paymentMethod2 = new PaymentMethod(2, "PayPal", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethod1);
        paymentMethodRepository.save(paymentMethod2);
        List<PaymentMethod> foundPaymentMethods = paymentMethodRepository.findAll();
        assertEquals(2, foundPaymentMethods.size(), "Failed to find all payment methods");
        assertTrue(foundPaymentMethods.contains(paymentMethod1));
        assertTrue(foundPaymentMethods.contains(paymentMethod2));
    }

    @Test
    void findAllTest_unexpected() {
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        List<PaymentMethod> foundPaymentMethods = paymentMethodRepository.findAll();
        PaymentMethodRepository expected_output=null;

        assertEquals(expected_output, foundPaymentMethods, "Failed to find all");


    }

    @Test
    void saveTest_expected() {
        PaymentMethod paymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethod);
        List<PaymentMethod> foundPaymentMethods = paymentMethodRepository.findAll();
        assertEquals(1, foundPaymentMethods.size(), "Failed to save payment method");
        assertEquals(paymentMethod, foundPaymentMethods.get(0), "Saved payment method does not match");
    }

    @Test
    void saveTest_unexpected() {
        PaymentMethod paymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethod);

        boolean saved = paymentMethodRepository.save(paymentMethod);
        assertFalse(saved, "Unexpectedly saved payment method");
    }

    @Test
    void updateTest_expected() {
        PaymentMethod initialPaymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(initialPaymentMethod);

        PaymentMethod updatedPaymentMethod = new PaymentMethod(1, "Debit Card", "Inactive");
        paymentMethodRepository.update(updatedPaymentMethod);
        PaymentMethod foundPaymentMethod = paymentMethodRepository.findById(1);

        boolean expected_output = true;
        boolean result=paymentMethodRepository.update(updatedPaymentMethod);

        assertEquals(result, expected_output, "Failed to update the payment method");
    }

    @Test
    void updateTest_unexpected() {
        PaymentMethod initialPaymentMethod = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(initialPaymentMethod);

        PaymentMethod updatedPaymentMethod = new PaymentMethod(2, "Debit Card", "Inactive");
        boolean updated = paymentMethodRepository.update(updatedPaymentMethod);
        assertFalse(updated, "Failed to update the payment method");
    }

    @Test
    void deleteTest_expected() {
        PaymentMethod paymentMethodToDelete = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethodToDelete);

        paymentMethodRepository.delete(1);
        PaymentMethod foundPaymentMethod = paymentMethodRepository.findById(1);

        assertNull(foundPaymentMethod, "Failed to delete payment method");
    }

    @Test
    void deleteTest_unexpected() {
        PaymentMethod paymentMethodToDelete = new PaymentMethod(1, "Credit Card", "Active");
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        paymentMethodRepository.save(paymentMethodToDelete);

        boolean result = paymentMethodRepository.delete(2);
        assertFalse(result, "Unexpectedly deleted payment method");
    }
}
