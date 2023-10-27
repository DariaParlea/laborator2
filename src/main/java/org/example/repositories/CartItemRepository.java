package org.example.repositories;

import org.example.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemRepository {
    private List<CartItem> cartItems = new ArrayList<>();
    public List<CartItem> findByUser(int userId){
        List<CartItem> userCartItems = new ArrayList<>();
        for (CartItem cartItem : cartItems){
            if (cartItem.getUser_id() == userId){
                userCartItems.add(cartItem);
            }
        }
        return userCartItems;
    }

    public List<CartItem> findAll(){
        return cartItems;
    }

    public void save(CartItem cartItem){
        for(CartItem existingCartItem : cartItems){
            if(existingCartItem.getBook().equals(cartItem.getBook()) && existingCartItem.getUser_id() == cartItem.getUser_id()){
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        cartItems.add(cartItem);
    }

    public void update(CartItem cartItem){
        for(int i=0; i<cartItems.size();i++){
            CartItem existingCartItem = cartItems.get(i);
            if(existingCartItem.getBook().equals(cartItem.getBook()) && existingCartItem.getUser_id() == cartItem.getUser_id()){
                cartItems.set(i,cartItem);
                return;
            }
        }
    }

    public void delete(CartItem cartItem){
        cartItems.removeIf(existingCartItem -> existingCartItem.getBook().equals(cartItem.getBook()) && existingCartItem.getUser_id() == cartItem.getUser_id());
    }
}
