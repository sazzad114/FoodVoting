package net.therap.service;

import net.therap.dao.FoodTypeDao;
import net.therap.dao.FoodTypeDaoImpl;
import net.therap.domain.FoodType;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodTypeServiceImpl implements FoodTypeService{

    public List<FoodType> getFoodTypeList(User user) {
        FoodTypeDao foodTypeDao = new FoodTypeDaoImpl();
       return  foodTypeDao.getFoodTypeList(user);
    }
}
