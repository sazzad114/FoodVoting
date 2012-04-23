package net.therap.dao;

import net.therap.domain.Food;
import net.therap.util.DatabaseTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodDaoImpl implements FoodDao{

    DatabaseTemplate dbTemplate;
   public FoodDaoImpl(){
        dbTemplate = new DatabaseTemplate();
    }

    public List<Food> getFoodList() {

        String query = "SELECT * FROM ASH_SAZ_FOOD";
       List<Food> foodList = dbTemplate.queryForObject(new RowFoodMapperImpl(),query);

        return foodList;

    }

    public List<Food> getFoodListByFoodType(int foodTypeId) {

        String query = "SELECT * FROM ASH_SAZ_FOOD WHERE FOOD_TYPE_ID = ?";
        List<Food> foodList = dbTemplate.queryForObject(new RowFoodMapperImpl(),query,foodTypeId);
        return foodList;

    }

    public Food getFoodById(int foodId) {
        String query = "SELECT * FROM ASH_SAZ_FOOD WHERE FOOD_ID = ?";
        List<Food> foodList;
        foodList = dbTemplate.queryForObject(new RowFoodMapperImpl(),query,foodId);
        if(foodList.size() == 0){
            return null;
        }
        else {
            return foodList.get(0);
        }
    }
}
