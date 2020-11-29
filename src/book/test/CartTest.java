package book.test;

import book.bean.Cart;
import book.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "知更鸟", 2, new BigDecimal(17.98), new BigDecimal(35.96), "static/img/default.jpg"));
        cart.addItem(new CartItem(1, "知更鸟", 1, new BigDecimal(17.98), new BigDecimal(35.96), "static/img/default.jpg"));
        cart.addItem(new CartItem(2, "长夜难明", 1, new BigDecimal(8.99), new BigDecimal(8.99), "static/img/default.jpg"));
        cart.addItem(new CartItem(3, "长夜难明", 1, new BigDecimal(10), new BigDecimal(10), "static/img/default.jpg"));
        System.out.println(cart.getItems());
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "知更鸟", 2, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(1, "知更鸟", 1, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(2, "长夜难明", 1, new BigDecimal(8), new BigDecimal(8), "static/img/default.jpg"));
        cart.addItem(new CartItem(3, "长夜难明", 1, new BigDecimal(10), new BigDecimal(10), "static/img/default.jpg"));
        System.out.println(cart.getItems());
        cart.deleteItem(1);
        System.out.println(cart.getItems());
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "知更鸟", 2, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(1, "知更鸟", 1, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(2, "长夜难明", 1, new BigDecimal(8), new BigDecimal(8), "static/img/default.jpg"));
        cart.addItem(new CartItem(3, "长夜难明", 1, new BigDecimal(10), new BigDecimal(10), "static/img/default.jpg"));
        System.out.println(cart.getItems());
        cart.clear();
        System.out.println(cart.getItems());
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "知更鸟", 2, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(1, "知更鸟", 1, new BigDecimal(17), new BigDecimal(34), "static/img/default.jpg"));
        cart.addItem(new CartItem(2, "长夜难明", 1, new BigDecimal(8), new BigDecimal(8), "static/img/default.jpg"));
        cart.addItem(new CartItem(3, "长夜难明", 1, new BigDecimal(10), new BigDecimal(10), "static/img/default.jpg"));
        System.out.println(cart.getItems());
        cart.updateCount(1,-1);
        System.out.println(cart);
    }
}