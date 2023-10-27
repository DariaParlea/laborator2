package org.example.model;

public class Publisher {
    private int publisher_id;
    private String name;
    private String address;
    private int fiscal_code;

    public Publisher(int publisher_id, String name, String address, int fiscal_code) {
        this.publisher_id = publisher_id;
        this.name = name;
        this.address = address;
        this.fiscal_code = fiscal_code;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFiscal_code() {
        return fiscal_code;
    }

    public void setFiscal_code(int fiscal_code) {
        this.fiscal_code = fiscal_code;
    }
}
