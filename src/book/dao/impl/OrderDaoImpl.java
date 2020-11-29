package book.dao.impl;

import book.dao.OrderDao;
import book.bean.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into b_order(order_id, create_time, price, status, user_id) values(?, ?, ?, ?, ?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId, create_time createTime, price, status, user_id userId from b_order";

        return queryForList(Order.class, sql);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select order_id orderId, create_time createTime, price, status, user_id userId from b_order where user_id = ?";

        return queryForList(Order.class, sql, userId);
    }

    @Override
    public void updateStatus(String orderId, Integer status) {
        String sql = "update b_order set status =? where order_id = ?";
        update(sql, status, orderId);
    }

    @Override
    public Order queryOrdersById(String orderId) {
        String sql = "select order_id orderId, create_time createTime, price, status, user_id userId from b_order where order_id =?";
        return queryForOne(Order.class, sql, orderId);
    }
}
