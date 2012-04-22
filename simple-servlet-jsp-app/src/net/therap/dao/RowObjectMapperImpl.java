package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.RowObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class RowObjectMapperImpl implements RowObjectMapper<User> {

    public User mapRowToObject(ResultSet resultSet) throws SQLException {

        if (resultSet.getRow() != 0) {

            User user = new User();
            user.setId(resultSet.getInt("USER_ID"));
            user.setUserName(resultSet.getString("USER_NAME"));
            user.setPassword(resultSet.getString("USER_PSD"));
            return user;  //To change body of implemented methods use File | Settings | File Templates.
        }
        else {

            return null;

        }
    }
}
