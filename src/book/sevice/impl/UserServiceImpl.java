package book.sevice.impl;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.bean.User;
import book.sevice.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    /**
     *
     * @param user
     * @return 返回null登录失败
     */
    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
