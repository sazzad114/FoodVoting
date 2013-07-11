package net.therap.service;

import net.therap.domain.FoodType;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FoodTypeService {
    List<FoodType> getFoodTypeList(User user);
}
