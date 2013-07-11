package net.therap.dao;

import net.therap.domain.User;
import net.therap.util.RowObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class RowUserMapperImpl implements RowObjectMapper<User> {
    private static final Logger log = LoggerFactory.getLogger(RowUserMapperImpl.class);
    public User mapRowToObject(ResultSet resultSet) throws SQLException {

        if (resultSet != null) {

            User user = new User();
            user.setId(resultSet.getInt("USER_ID"));
            user.setUserName(resultSet.getString("USER_NAME"));
            user.setPassword(resultSet.getString("USER_PSD"));
            log.debug("@@@@"+resultSet.getString("USER_TYPE_NAME"));
            if(resultSet.getString("USER_TYPE_NAME").equals("admin")){
                user.setAdmin(true);
            }
            else {
                user.setAdmin(false);
            }
            return user;  //To change body of implemented methods use File | Settings | File Templates.
        }
        else {

            return null;

        }
    }
}
