package org.example.repositories;

import org.example.main.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemRepository {
    private List<CartItem> cartItems = new ArrayList<>();

    public CartItemRepository(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> findAll(){
        return cartItems;
    }

    public void save(CartItem cartItem){
        for(CartItem existingCartItem : cartItems){
            if(existingCartItem.getBook().equals(cartItem.getBook())){
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        cartItems.add(cartItem);
    }

    public void update(CartItem cartItem){
        for(int i=0; i<cartItems.size();i++){
            CartItem existingCartItem = cartItems.get(i);
            if(existingCartItem.getBook().equals(cartItem.getBook())){
                cartItems.set(i,cartItem);
                return;
            }
        }
    }

    public void delete(CartItem cartItem){
        cartItems.removeIf(existingCartItem -> existingCartItem.getBook().equals(cartItem.getBook()) );
    }
}
