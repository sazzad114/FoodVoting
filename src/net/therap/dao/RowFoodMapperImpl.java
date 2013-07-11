package net.therap.dao;


import net.therap.domain.Food;
import net.therap.domain.User;
import net.therap.util.RowObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class RowFoodMapperImpl implements RowObjectMapper<Food> {


    public Food mapRowToObject(ResultSet resultSet) throws SQLException {
        Food food = new Food();
        if(resultSet != null)
        {
           food.setFoodId(resultSet.getInt("FOOD_ID"));
           food.setFoodName(resultSet.getString("FOOD_NAME"));
           food.setFoodImageLink(resultSet.getString("IMAGE_LINK"));
           food.setFoodTypeId(resultSet.getInt("FOOD_TYPE_ID"));
        }
        return food;
    }
}
