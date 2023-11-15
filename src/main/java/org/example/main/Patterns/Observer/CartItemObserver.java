package org.example.main.Patterns.Observer;

import org.example.main.CartItem;

public interface CartItemObserver {
    void update(CartItem cartItem);
}
