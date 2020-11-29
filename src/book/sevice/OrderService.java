package book.sevice;

import book.bean.Cart;
import book.bean.Order;
import book.bean.OrderItem;

import java.util.List;

public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

    public List<Order> queryOrders();

    public List<Order> queryOrdersByUserId(Integer userId);

    public void updateStatus(String orderId, Integer status);

    public Order queryOrdersById(String orderId);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
