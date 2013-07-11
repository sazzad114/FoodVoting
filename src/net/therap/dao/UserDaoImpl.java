package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao {

    DatabaseTemplate dbTemplate;

    public UserDaoImpl(){

        dbTemplate = DatabaseTemplate.getDatabaseTemplate();

    }
    public User getUserByUserName(String userName){

        String query = "select * from ASH_SAZ_USER,ASH_SAZ_USER_TYPE where USER_NAME = ? AND ASH_SAZ_USER.USER_TYPE_ID = ASH_SAZ_USER_TYPE.USER_TYPE_ID";

        List<User> userList = dbTemplate.queryForObject(new RowUserMapperImpl(),query,userName.trim());

        if(userList.size() == 0){
            return null;
        }
        else {
            return userList.get(0);
        }
    }

    public User getUserById(int userId) {

        String query = "select * from ASH_SAZ_USER,ASH_SAZ_USER_TYPE where ASH_SAZ_USER.USER_TYPE_ID = ASH_SAZ_USER_TYPE.USER_TYPE_ID AND  USER_ID = ?";

        List<User> userList = dbTemplate.queryForObject(new RowUserMapperImpl(),query,userId);

        if(userList.size() == 0){
            return null;
        }
        else {
            return userList.get(0);
        }
    }
}


