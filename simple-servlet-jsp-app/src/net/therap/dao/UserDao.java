package net.therap.dao;

import net.therap.domain.User;


public interface UserDao {


    User getUserByUserNamePassword(String userName , String password);
    User getUserById(int userId);
}
