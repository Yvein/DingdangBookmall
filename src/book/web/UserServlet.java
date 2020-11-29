package book.web;

import book.bean.User;
import book.sevice.UserService;
import book.sevice.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 登录方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("处理登录事务");

        //获取请求的参数
        //String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        //String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //userService.login()
        User loginUser = userService.login(new User(null, username, password, null));

        //判断登录结果跳转
        if(loginUser == null){
            //登录失败把错误信息和表单项信息保存到Request域中
            req.setAttribute("loginError", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            System.out.println("用户名或密码错误，登录失败！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{//登录成功
            //保存用户登录后的信息到Session域中
            req.getSession().setAttribute("user", loginUser);
            System.out.println("验证通过，登录成功！");
//            req.getRequestDispatcher("client/bookServlet?action=page").forward(req, resp);
            resp.sendRedirect(req.getContextPath());
        }
    }

    /**
     * 注册的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理注册的事务");

        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //检查验证码是否正确

        //检查用户名是否正确
        if(userService.existsUsername(username)){
            //注册失败把错误信息和表单项信息保存到Request域中
            req.setAttribute("registError", "用户名已存在！");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);
            System.out.println("用户名已存在！");
            //跳转到注册页面
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }else {
            System.out.println("用户名可用");
            //调用Sservice保存到数据库
            userService.registUser(new User(null, username, password, email));
            //跳到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    /**
     * 注销用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}

