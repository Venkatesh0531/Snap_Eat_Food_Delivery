package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.tap.model.Order_item;
import com.tap.utility.DB_Connection;

public class OrderItem_DAO_Imple {

    public Map<Integer, ArrayList<Order_item>> getOrderItemsByUser(int user_id) {

        Map<Integer, ArrayList<Order_item>> orderItemsMap = new HashMap<>();

        String GET_ORDER_ITEMS =
            "SELECT oi.* " +
            "FROM order_item oi " +
            "JOIN orders o ON oi.order_id = o.order_id " +
            "WHERE o.user_id = ?";

        try {
            Connection connection = DB_Connection.getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(GET_ORDER_ITEMS);

            stmt.setInt(1, user_id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                int orderId = res.getInt("order_id");

                Order_item item = new Order_item();
                item.setOrder_item_id(res.getInt("order_item_id"));
                item.setOrder_id(orderId);
                item.setItem_name(res.getString("item_name"));
                item.setQuantity(res.getInt("quantity"));
                item.setTotal_price(res.getDouble("total_price"));

                orderItemsMap
                    .computeIfAbsent(orderId, k -> new ArrayList<>())
                    .add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemsMap;
    }
}
