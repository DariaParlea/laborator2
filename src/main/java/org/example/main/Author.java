package org.example.main;


public class Author {
    private int author_id;
    private String firstName;
    private String lastName;
    private String birth_date;
    private String address;

    public Author(int author_id, String firstName, String lastName, String birth_date, String address) {
        this.author_id = author_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_date = birth_date;
        this.address = address;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
