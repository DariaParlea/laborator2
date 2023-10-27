package org.example.model;



public class Clients {
    private int client_id;
    private String firstName;
    private String lastName;
    private String birth_date;
    private String addresses;
    private String email;

    public Clients(int client_id, String firstName, String lastName, String birth_date, String addresses, String email) {
        this.client_id = client_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_date = birth_date;
        this.addresses = addresses;
        this.email = email;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
