package org.example.model;

public class Orders {
    private int order_id;
    private String date;
    private int total_price;
    private int client_id;
    private String status;

    public Orders(int order_id, String date, int total_price, int client_id, String status) {
        this.order_id = order_id;
        this.date = date;
        this.total_price = total_price;
        this.client_id = client_id;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
