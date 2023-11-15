package org.example.main;

import org.example.main.Patterns.Observer.CartItemObserver;

import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private Books book;
    private int quantity;
    private List<CartItemObserver> observers = new ArrayList<>();


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
        this.quantity = quantity;
        notifyObservers();
    }

    public void addObserver(CartItemObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CartItemObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (CartItemObserver observer : observers) {
            observer.update(this);
        }
    }

}
