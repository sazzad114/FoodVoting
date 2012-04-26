package net.therap.dao;

import net.therap.util.ResultSetMapMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/25/12
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResultsetMapMapperImpl implements ResultSetMapMapper<Integer, Integer> {
    public Map<Integer, Integer> getMapFromResultset(ResultSet resultSet) throws SQLException {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (resultSet.next()) {
            map.put(resultSet.getInt("FOOD_ID"), resultSet.getInt("VOTE_NUM"));
        }
        return map;
    }
}
