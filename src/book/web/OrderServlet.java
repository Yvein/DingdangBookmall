package book.web;

import book.bean.Cart;
import book.bean.Order;
import book.bean.OrderItem;
import book.bean.User;
import book.sevice.OrderService;
import book.sevice.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }


    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deliver(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.updateStatus(orderId, 1);
        req.getRequestDispatcher("orderServlet?action=showOrder").forward(req, resp);
    }


    /**
     * 确认收货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void receipt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.updateStatus(orderId, 2);
        req.getRequestDispatcher("orderServlet?action=myOrder").forward(req, resp);
    }

    /**
     * 后台查看订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.queryOrders();

        req.setAttribute("orders", orders);

        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    /**
     * 我的订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        Integer userId = user.getId();

        List<Order> orders = orderService.queryOrdersByUserId(userId);
        System.out.println(orders);

        req.setAttribute("orders", orders);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void orderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderId = req.getParameter("orderId");

        Order order = orderService.queryOrdersById(orderId);
        req.setAttribute("order", order);

        List<OrderItem> orderItems = orderService.queryOrderItemsByOrderId(orderId);
        req.setAttribute("orderItems", orderItems);

        int count = 0;
        for (OrderItem orderItem : orderItems) {
            count += orderItem.getCount();
        }
        req.setAttribute("count", count);

        req.getRequestDispatcher("/pages/order/orderDetail.jsp").forward(req, resp);
    }


}
