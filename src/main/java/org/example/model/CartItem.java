package org.example.model;

public class CartItem {
    private Books book;
    private int quantity;

    private int user_id;

    public CartItem(Books book, int quantity, int user_id) {
        this.book = book;
        this.quantity = quantity;
        this.user_id = user_id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
