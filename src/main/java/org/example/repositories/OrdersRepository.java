package org.example.repositories;


import org.example.main.Orders;

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
        System.out.println("Could not find order with Id: " + targetOrderId);
        return null;
    }

    public List<Orders> findAll() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
            return null;
        }
        return orders;
    }


    public boolean save(Orders order) {
        boolean saved = false;
        for (Orders item : orders) {
            if (order.getOrder_id() == item.getOrder_id()) {
                System.out.println("Order already exists");
                return saved;
            }

        }
        orders.add(order);
        for (Orders item : orders) {
            if (order.getOrder_id() == item.getOrder_id())
                saved = true;
        }

        return saved;
    }

    public boolean update(Orders updatedOrder) {
        boolean updated = false;
        for (Orders order : orders) {
            if (order.getOrder_id() == updatedOrder.getOrder_id()) {
                order.setDate(updatedOrder.getDate());
                order.setClient_id(updatedOrder.getClient_id());
                order.setStatus(updatedOrder.getStatus());
                order.calculateTotalPrice();
                updated = true;
                break;
            }
        }
        if (updated == false)
            System.out.println("Order was not updated");

        return updated;
    }

    public boolean delete(int targetOrderId) {
        boolean deleted = false;
        Orders orderToRemove = null;
        for (Orders order : orders) {
            if (order.getOrder_id() == targetOrderId) {
                orderToRemove = order;
                break;
            }
        }
        if (orderToRemove == null) {
            System.out.println("Order does not exist");
            deleted = false;
        }
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
            deleted = true;
        }
        return deleted;


    }


}