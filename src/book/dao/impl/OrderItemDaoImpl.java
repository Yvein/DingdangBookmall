package book.dao.impl;

import book.dao.OrderItemDao;
import book.bean.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into b_order_item(name, count, price, total_price, order_id, img_path) values(?, ?, ?, ?, ?, ?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId(), orderItem.getImgPath());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select id, name, count, price, total_price totalPrice, order_id orderId, img_path imgPath from b_order_item where order_id=?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
