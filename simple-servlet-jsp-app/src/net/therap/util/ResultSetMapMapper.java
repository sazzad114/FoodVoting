package net.therap.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/25/12
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ResultSetMapMapper <K,V> {

    Map<K,V> getMapFromResultset(ResultSet resultSet) throws SQLException;
}
