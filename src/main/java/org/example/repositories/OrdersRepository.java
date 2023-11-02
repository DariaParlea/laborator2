package org.example.repositories;


import org.example.model.Orders;
import java.util.ArrayList;
import java.util.List;
public class OrdersRepository {

    private List<Orders> orders = new ArrayList<>();

    public Orders findById(int targetOrderId) {
        for (Orders order : orders) {
            if (order.getOrder_id() == targetOrderId) {
                return order;
            }
        }
        return null;
    }

    public List<Orders> findAll() {
        return orders;
    }


    public void save(Orders order) {
        orders.add(order);
    }

    public void update(Orders updatedOrder) {
        for (Orders order : orders) {
            if (order.getOrder_id() == updatedOrder.getOrder_id()) {
                order.setDate(updatedOrder.getDate());
                order.setTotal_price(updatedOrder.getTotal_price());
                order.setClient_id(updatedOrder.getClient_id());
                order.setStatus(updatedOrder.getStatus());
                break;
            }
        }
    }

    public void delete(int targetOrderId) {
        Orders orderToRemove = null;
        for (Orders order : orders) {
            if (order.getOrder_id() == targetOrderId) {
                orderToRemove = order;
                break;
            }
        }
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
        }
    }




}