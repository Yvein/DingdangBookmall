package book.test;

import book.bean.Cart;
import book.bean.CartItem;
import book.bean.Order;
import book.bean.OrderItem;
import book.sevice.OrderService;
import book.sevice.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "知更鸟", 2, new BigDecimal(17.98), new BigDecimal(35.96), "static/img/default.jpg"));
        cart.addItem(new CartItem(1, "知更鸟", 1, new BigDecimal(17.98), new BigDecimal(17.98), "static/img/default.jpg"));
        cart.addItem(new CartItem(2, "长夜难明", 1, new BigDecimal(8.99), new BigDecimal(8.99), "static/img/default.jpg"));
        System.out.println(cart);
        orderService.createOrder(cart, 1);

    }

    @Test
    public void queryOrders() {
        for (Order order : orderService.queryOrders()) {
            System.out.println(order);
        }
    }

    @Test
    public void queryOrdersByUserId() {
        for (Order order : orderService.queryOrdersByUserId(3)) {
            System.out.println(order);
        }

    }

    @Test
    public void updateStatus() {
        orderService.updateStatus("1234567890", 1);
    }

    @Test
    public void queryOrdersById() {
        System.out.println(orderService.queryOrdersById("16065755045161"));
    }

    @Test
    public void queryOrdersByOrderId() {
        for (OrderItem orderItem : orderService.queryOrderItemsByOrderId("16065755045161")) {
            System.out.println(orderItem);
        }

    }
}