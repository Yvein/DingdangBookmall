package book.sevice.impl;

import book.dao.BookDao;
import book.dao.OrderDao;
import book.dao.OrderItemDao;
import book.dao.impl.BookDaoImpl;
import book.dao.impl.OrderDaoImpl;
import book.dao.impl.OrderItemDaoImpl;
import book.bean.Cart;
import book.bean.CartItem;
import book.bean.Order;
import book.bean.OrderItem;
import book.sevice.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //生成订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //保存订单
        orderDao.saveOrder(order);
        //将购物车中的每一个商品项保存为订单项
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            orderItemDao.saveOrderItem(new OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId, cartItem.getImgPath()));
        }
        //清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> queryOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void updateStatus(String orderId, Integer status) {
        orderDao.updateStatus(orderId,status);
    }

    @Override
    public Order queryOrdersById(String orderId) {
        return orderDao.queryOrdersById(orderId);
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }
}
