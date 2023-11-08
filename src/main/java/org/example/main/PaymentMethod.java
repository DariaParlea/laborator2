package org.example.main;

public class PaymentMethod {
    private int payment_id;
    private String type;
    private String status;

    public PaymentMethod(int payment_id, String type, String status) {
        this.payment_id = payment_id;
        this.type = type;
        this.status = status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
