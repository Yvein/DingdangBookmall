package book.test;

import book.dao.OrderDao;
import book.dao.impl.OrderDaoImpl;
import book.bean.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567890", new Date(), new BigDecimal(200), 0, 1));
    }

    @Test
    public void queryOrders() {
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order : orderDao.queryOrders()) {
            System.out.println(order);
        }
    }

    @Test
    public void queryOrdersByUserId() {
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order : orderDao.queryOrdersByUserId(3)) {
            System.out.println(order);
        }

    }

    @Test
    public void updateStatus() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateStatus("1234567890", 2);
    }

    @Test
    public void queryOrdersById() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.queryOrdersById("16065466508261"));
    }


}