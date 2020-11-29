package book.web;

import book.bean.Book;
import book.bean.Page;
import book.sevice.BookService;
import book.sevice.impl.BookServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNow = 0;
        if(req.getParameter("pageNow") != null) {
            pageNow = Integer.parseInt(req.getParameter("pageNow"));
        }
        pageNow += 1;
        //获取参数封装成为Book对象
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        //String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        //String author = new String(req.getParameter("author").getBytes("iso-8859-1"), "utf-8");
        BigDecimal discount = new BigDecimal(req.getParameter("discount"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Book book = new Book(null, name, author, discount, price, null );
        //通过BookService添加书目
        bookService.addBook(book);
        //请求转发到/pages/manager/book_manager.jsp
        //不能请求转发得用重定向
        //req.getRequestDispatcher("").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNow=" + pageNow);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数id
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //调用bookService.deleteBookById()
        bookService.deleteBookById(id);
        //重定向到/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNow=" + req.getParameter("pageNow"));
    }

    /**
     * 提交修改
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数id
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //获取参数封装成为Book对象
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        BigDecimal discount = new BigDecimal(req.getParameter("discount"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Book book = new Book(id, name, author, discount, price, null );

        //通过BookService添加书目
        bookService.updateBook(book);

        //重定向到/pages/manager/book_manager.jsp
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNow=" + req.getParameter("pageNow"));
    }

    /**
     * 获取待修改的图书信息并回显到表单中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Book book = bookService.queryBookById(id);
        //保存到request域
//        req.setAttribute("name", book.getName());
//        req.setAttribute("author", book.getAuthor());
//        req.setAttribute("discount", book.getDiscount());
//        req.setAttribute("price", book.getPrice());
        req.setAttribute("book", book);
        //请求转发到/pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

//    //查询列表并回显
//    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //通过BookService查询全部图书
//        List<Book> books = bookService.queryBooks();
//        //保存查询到的内容到Request域中
//        req.setAttribute("books", books);
//        //请求转发到/pages/manager/book_manager.jsp
//        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
//    }

    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageNow，pageSize
        Integer pageNow = 1;
        if(req.getParameter("pageNow") != null) {
            pageNow = Integer.parseInt(req.getParameter("pageNow"));
        }
        Integer pageSize = Page.PAGE_SIZE;

        if(req.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

        //调用bookService.page(pageNum, pageSize):返回Page对象
        Page<Book> page = bookService.page(pageNow, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //保存Page对象到Request域
        req.setAttribute("page", page);

        //请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
