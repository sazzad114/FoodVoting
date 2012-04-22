
package net.therap.util;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 4/10/12
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RowObjectMapper<E> {

     E mapRowToObject(ResultSet resultSet) throws SQLException;
}