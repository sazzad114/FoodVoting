package net.therap.dao;

import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.util.DatabaseTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodTypeDaoImpl implements FoodTypeDao{

    DatabaseTemplate dbTemplate;

    public FoodTypeDaoImpl(){

        dbTemplate = new DatabaseTemplate();
    }

    public List<FoodType> getFoodTypeList(User user) {
       String query = "SELECT * FROM ASH_SAZ_FOOD_TYPE";
       //dbTemplate.openConnection();
       List<FoodType> foodTypeList = dbTemplate.queryForObject(new RowFoodTypeMapperImpl(user),query);
        //dbTemplate.closeConnection();
       return foodTypeList;
    }

    public FoodType getFoodTypeListById(int foodTypeId) {
       String query = "SELECT * FROM ASH_SAZ_FOOD_TYPE WHERE FOOD_TYPE_ID = ?";
       //dbTemplate.openConnection();
       List<FoodType> foodTypeList = dbTemplate.queryForObject(new RowFoodTypeMapperImpl(),query,foodTypeId);
        //dbTemplate.closeConnection();
        if(foodTypeList.size() == 0){
            return null;
        }
        else {
            return foodTypeList.get(0);
        }
    }
}
