package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.*;

import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl implements UserDao{

    DatabaseTemplate dbTemplate;

    public UserDaoImpl(){

        //Properties properties = PropertiesReaderUtils.loadProperties("../../../db.properties");
        //dbTemplate = new DatabaseTemplate(properties.getProperty("jdbc.url.address"),properties.getProperty("db.user"),properties.getProperty("db.password"),properties.getProperty("jdbc.driver"));
        dbTemplate = new DatabaseTemplate("jdbc:oracle:thin:@db102:1521:THERAP","trainee","pass321","oracle.jdbc.driver.OracleDriver");
    }
    public User getUserByUserNamePassword(String userName , String password){

        String query = "select * from ASH_SAZ_USER where USER_NAME = '"+userName.trim()+"'"+" AND USER_PSD = '"+password.trim()+"'";
        List<User> userList = dbTemplate.queryForObject(query,new RowObjectMapperImpl());
        if(userList.size() == 0){
            return null;
        }
        else {
            return userList.get(0);
        }
    }
}


