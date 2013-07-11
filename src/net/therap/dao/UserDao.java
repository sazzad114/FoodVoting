package net.therap.dao;

import net.therap.domain.User;


public interface UserDao {


    User getUserByUserName(String userName);
    User getUserById(int userId);
}
