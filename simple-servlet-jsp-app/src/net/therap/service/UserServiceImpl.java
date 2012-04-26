package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.dao.UserDaoImpl;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService{

    public User getUserByUserNameAndPassword(String userName, String password){

        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByUserName(userName);

        if(user != null && password.trim().equals(user.getPassword().trim()))
        {
             return user;
        }
        else
        {
            return null;
        }

    }
}
