package net.therap.dao;

import net.therap.domain.FoodType;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FoodTypeDao {
    List<FoodType> getFoodTypeList(User user);
    FoodType getFoodTypeListById(int foodTypeId);
}
