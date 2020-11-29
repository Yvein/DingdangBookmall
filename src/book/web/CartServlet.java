package book.web;

import book.bean.Book;
import book.bean.Cart;
import book.bean.CartItem;
import book.sevice.BookService;
import book.sevice.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("加入购物车,商品编号为：" + req.getParameter("id"));
        //通过id获取图书信息，创建商品项
        int id = 0;
        if(req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getDiscount(), book.getDiscount(),book.getImgPath());

        //从session域中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断有无cart，没有则创建
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        //重定向到首页
        resp.sendRedirect(req.getHeader("Referer") + "#here");

    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品项id
        int id = 0;
        if(req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        //从session域中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);

        //重定向到首页
        resp.sendRedirect("pages/cart/cart.jsp");

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session域中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();

        //重定向到首页
        resp.sendRedirect("pages/cart/cart.jsp");
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品项id
        int id = 0;
        if(req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
//        System.out.println(id);
        int count = 1;
        if(req.getParameter("count") != null) {
            count = Integer.parseInt(req.getParameter("count"));
        }
        //从session域中获取cart
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.updateCount(id, count);
        //重定向到首页
        resp.sendRedirect("pages/cart/cart.jsp");
    }
}
