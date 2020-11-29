package book.test;

import book.bean.User;
import book.sevice.UserService;
import book.sevice.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "cqq", "123456", "cqq@book.com"));
        userService.registUser(new User(null, "cy", "123456", "cy@book.com"));
        userService.registUser(new User(null, "ce", "123456", "ce@book.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("cyf"));
        System.out.println(userService.existsUsername("cyf1"));
        System.out.println(userService.existsUsername("cqq"));
    }
}