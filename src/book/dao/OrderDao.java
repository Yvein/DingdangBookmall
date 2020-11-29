package book.dao;

import book.bean.Order;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public List<Order> queryOrdersByUserId(Integer userId);

    public void updateStatus(String orderId, Integer status);

    public Order queryOrdersById(String orderId);
}
