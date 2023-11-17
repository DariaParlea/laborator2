package org.example.main.Patterns.Observer;

import org.example.main.CartItem;

public interface CartItemObservable {
    public void notifyObserver(String event, CartItem cartItem);
}
