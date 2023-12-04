package org.example.BD_Repository;
import org.example.main.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.SqlServer;
import org.example.main.Patterns.Strategy.BankTransferPaymentStrategy;
import org.example.main.Patterns.Strategy.CardPaymentStrategy;
import org.example.main.Patterns.Strategy.CashPaymentStrategy;
import org.example.main.Patterns.Strategy.PaymentStrategy;

public class PaymentMethodRepositoryBD {
    private SqlServer sqlServer;

    public PaymentMethodRepositoryBD(SqlServer sqlServer) {
        this.sqlServer = sqlServer;
    }

    public void saveIntoDB(PaymentMethod paymentMethod){
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO labor.Paymentmethod(PaymentID, Status, PaymentStrategy) VALUES (?,?,?)")){

                preparedStatement.setInt(1,paymentMethod.getPayment_id());
                preparedStatement.setString(2, paymentMethod.getStatus());
                preparedStatement.setString(3,paymentMethod.getPaymentStrategy().getPaymentType());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public PaymentMethod createPaymentMethodFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("PaymentID");
        String status = resultSet.getString("Status");
        String paymentstrategy = resultSet.getString("PaymentStrategy");
        PaymentStrategy type;
        if (paymentstrategy.equalsIgnoreCase("cash")) {
            type = new CashPaymentStrategy();
        } else {
            if (paymentstrategy.equalsIgnoreCase("card")) {
                type = new CardPaymentStrategy();
            } else {
                type = new BankTransferPaymentStrategy();
            }
        }
        PaymentMethod paymentMethod = new PaymentMethod(id,status,type);
        return paymentMethod;
    }

    public List<PaymentMethod> loadFromDB(){
        List<PaymentMethod> result = new ArrayList<>();
        try (Connection connection = sqlServer.connect();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM labor.PaymentMethod";
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(createPaymentMethodFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public PaymentMethod findByID(int id){
        List<PaymentMethod> allPaymentMethods = loadFromDB();
        PaymentMethod found = null;
        for(PaymentMethod paymentMethod:allPaymentMethods){
            if(paymentMethod.getPayment_id()== id)
                found = paymentMethod;
        }

        return found;
    }

    public void updateStatus(int Id, String newstatus) {
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE labor.Paymentmethod SET Status = ? WHERE PaymentID = ?")) {

            preparedStatement.setString(1,newstatus);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try (Connection connection = sqlServer.connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM labor.PaymentMethod WHERE PaymentID = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
