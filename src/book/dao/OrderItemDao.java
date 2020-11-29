package book.dao;

import book.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
