package book.filter;

import book.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        User user = (User) httpServletRequest.getSession().getAttribute("user");

        if(user == null){     //未登录,跳转到登录界面
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else {      //已登录
//            System.out.println("【" + user.getUsername() + "】");
            if(user.getUsername().equals("admin")){  //如果为管理员账号，放行
//                System.out.println("欢迎，管理员admin");
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
//                JOptionPane.showMessageDialog(null, "没有该权限");
//                JOptionPane.showMessageDialog(null, "你不是管理员","没有此权限",JOptionPane.ERROR_MESSAGE);
                httpServletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
