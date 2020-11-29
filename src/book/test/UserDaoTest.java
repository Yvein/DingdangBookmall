package book.test;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用！");
        }
        else System.out.println("用户名已存在！");
    }


    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPassword("admin", "admin") == null){
            System.out.println("用户名或密码错误，登录失败！");
        }
        else System.out.println("登录成功！");
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.saveUser(new User(null, "cyf", "123456", "cc12@qq.com")) == -1){
            System.out.println("注册失败！");
        }
        else System.out.println("注册成功！");
    }
}