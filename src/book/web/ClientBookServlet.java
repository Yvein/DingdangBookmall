package book.web;

import book.bean.Book;
import book.bean.Page;
import book.sevice.BookService;
import book.sevice.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageNow，pageSize
        Integer pageNow = 1;
        if(req.getParameter("pageNow") != null) {
            pageNow = Integer.parseInt(req.getParameter("pageNow"));
        }
        Integer pageSize = 8;

        if(req.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

        //调用bookService.page(pageNum, pageSize):返回Page对象
        Page<Book> page = bookService.page(pageNow, pageSize);

        page.setUrl("client/bookServlet?action=page");

        //保存Page对象到Request域
        req.setAttribute("page", page);

        //请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }


    /**
     * 搜索框查找按名称进行分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageNow, pageSize, keyword
        Integer pageNow = 1;
        if(req.getParameter("pageNow") != null) {
            pageNow = Integer.parseInt(req.getParameter("pageNow"));
        }
        Integer pageSize = 9;

        if(req.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(req.getParameter("pageSize"));
        }

        String keyWord = req.getParameter("keyword");

        if(keyWord=="" || keyWord==null){
            req.getRequestDispatcher("/client/bookServlet?action=page").forward(req, resp);
        }

        //调用bookService.pageByName();得到page分页对象
        Page<Book> page = bookService.pageByName(pageNow, pageSize, keyWord);

        page.setUrl("client/bookServlet?action=pageByName&keyword=" + keyWord);

        page.setKeyword(keyWord);

        //保存分页对象到Request域中
        req.setAttribute("page", page);

        //请求转发到
        req.getRequestDispatcher("/pages/client/searchResult.jsp").forward(req, resp);
    }
}
