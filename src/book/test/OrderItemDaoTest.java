package book.test;

import book.dao.OrderItemDao;
import book.dao.impl.OrderItemDaoImpl;
import book.bean.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"知更鸟（令人心碎的爱情悲剧，天衣无缝的犯罪戏码…",
                1, new BigDecimal(17.98), new BigDecimal(17.98), "1234567890", "static/img/seckill-item1.jpg"));
    }

    @Test
    public void queryOrdersByOrderId() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        for (OrderItem orderItem : orderItemDao.queryOrderItemsByOrderId("16065755045161")) {
            System.out.println(orderItem);
        }
    }
}