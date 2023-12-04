package org.example.BD_Controller;

import org.example.BD_Repository.CartItemRepositoryBD;
import org.example.main.CartItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.example.main.CartItem;
import org.example.repositories.CartItemRepository;

public class CartItemControllerBD {
    private CartItemRepositoryBD cartItemRepositoryBD;

    public CartItemControllerBD(CartItemRepositoryBD cartItemRepositoryBD) {
        this.cartItemRepositoryBD = cartItemRepositoryBD;
    }

    public void saveIntoDB(List<CartItem> CartItems){
        cartItemRepositoryBD.saveIntoDB(CartItems);
    }

    public CartItem createCartItemFromResultSet(ResultSet resultSet) throws SQLException{
        return cartItemRepositoryBD.createCartItemFromResultSet(resultSet);
    }

    public List<CartItem> loadFromDB(){
        return cartItemRepositoryBD.loadFromDB();
    }


    public void delete(int bookid){
        cartItemRepositoryBD.delete(bookid);
    }
}