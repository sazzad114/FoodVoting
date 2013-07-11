package net.therap.dao;

import net.therap.domain.Food;
import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.domain.Vote;
import net.therap.util.RowObjectMapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class RowFoodTypeMapperImpl implements RowObjectMapper<FoodType>{
    FoodDao foodDao;
    VoteDao voteDao;
    UserDao userDao;
    User user;

    public RowFoodTypeMapperImpl()
    {
        foodDao = new FoodDaoImpl();
        voteDao = new VoteDaoImpl();
        userDao = new UserDaoImpl();
    }

    public RowFoodTypeMapperImpl(User user)
    {
        foodDao = new FoodDaoImpl();
        voteDao = new VoteDaoImpl();
        userDao = new UserDaoImpl();
        this.user = user;
    }

    public FoodType mapRowToObject(ResultSet resultSet) throws SQLException {
        Vote vote;
        FoodType foodType = new FoodType();
        if(resultSet != null)
        {
            int foodTypeId =  resultSet.getInt("FOOD_TYPE_ID");
            foodType.setFoodTypeId(foodTypeId);
            foodType.setFoodTypeName(resultSet.getString("FOOD_TYPE_NAME"));
            foodType.setFoodList(foodDao.getFoodListByFoodType(foodTypeId));
            vote = voteDao.getVoteByUserFoodType(user, foodTypeId);
            if(vote != null)
               foodType.setVotedFood(vote.getFood());
            else {
               foodType.setVotedFood(null);
            }

        }
        return foodType;
    }
}
