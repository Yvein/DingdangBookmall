package book.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("调用login()方法");
    }
    public void regist(){
        System.out.println("调用regist()方法");
    }
    public void updateUser(){
        System.out.println("调用updateUser()方法");
    }
    public void updateUserPassword(){
        System.out.println("调用updateUserPassword()方法");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(method);

            try {
                method.invoke(new UserServletTest() );
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
