package org.example.BD_Repository;
import org.example.main.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.SqlServer;
import org.example.main.Patterns.Observer.CartItemObservable;
import org.example.main.Patterns.Observer.OrderObserver;

public class CartItemRepositoryBD implements CartItemObservable {
    private SqlServer sqlServer;
    private OrderObserver observer;

    public CartItemRepositoryBD(SqlServer sqlServer) {
        this.sqlServer = sqlServer;
    }

    public void saveIntoDB(List<CartItem> cartItems){
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO labor.CartItem(BookID, Quantity) VALUES (?,?)")){

            for(CartItem cartItem : cartItems){
                preparedStatement.setInt(1,cartItem.getBook().getBook_id());
                preparedStatement.setInt(2,cartItem.getQuantity());
            }

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public CartItem createCartItemFromResultSet(ResultSet resultSet) throws SQLException{
        BooksRepositoryDB booksRepositoryDB = new BooksRepositoryDB(sqlServer);
        int id = resultSet.getInt("BookID");
        int quantity = resultSet.getInt("Quantity");
        Books book = booksRepositoryDB.findByID(id);
        CartItem cartItem = new CartItem(book,quantity);
        return cartItem;
    }

    public List<CartItem> loadFromDB(){
        List<CartItem> result = new ArrayList<>();
        try (Connection connection = sqlServer.connect();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM labor.CartItem";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createCartItemFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateQuantity(int id, int newquantity) {
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE labor.CartItem SET Quantity = ? WHERE BookID = ?")) {

            preparedStatement.setInt(1, newquantity);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE labor.Order_CartItem SET Quantity = ? WHERE BookID = ?")) {

            preparedStatement.setInt(1, newquantity);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int bookid){
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM labor.CartItem WHERE BookID = ?")) {

            preparedStatement.setInt(1, bookid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyObserver(String event, CartItem cartItem) {

        observer.update_event(event, cartItem);
    }
}
