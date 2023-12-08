package org.example.main;

import org.example.main.Patterns.Observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private Books book;
    private int quantity;


    public CartItem(Books book, int quantity) {
        this.book = book;
        this.quantity = quantity;
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

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
