package net.therap.dao;

import net.therap.domain.Food;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FoodDao {

    List<Food> getFoodList();
    List<Food> getFoodListByFoodType(int typeId);
    Food getFoodById(int foodId);
}
