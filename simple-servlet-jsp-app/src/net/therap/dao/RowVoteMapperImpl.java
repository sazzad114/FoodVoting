package net.therap.dao;

import net.therap.domain.Food;
import net.therap.domain.Vote;
import net.therap.util.RowObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class RowVoteMapperImpl implements RowObjectMapper<Vote>{
    private static final Logger log = LoggerFactory.getLogger(VoteDaoImpl.class);
    FoodDao foodDao;
    UserDao userDao;

    RowVoteMapperImpl(){

        foodDao = new FoodDaoImpl();
        userDao = new UserDaoImpl();
    }

    public Vote mapRowToObject(ResultSet resultSet) throws SQLException {
        log.debug("before returning vote");
        Vote vote =  new Vote();
        if(resultSet != null){
         int foodId = resultSet.getInt("FOOD_ID");
         int userId = resultSet.getInt("USER_ID");
         vote.setVoteId(resultSet.getInt("USER_FOOD_VOTE_ID"));
         vote.setVotingDate(resultSet.getDate("VOTING_DATE"));
         vote.setFood(foodDao.getFoodById(foodId));
         vote.setUser(userDao.getUserById(userId));

        }
        else {

            vote = null;
        }

        return vote;

    }
}
