package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.Vote;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VoteDao {

    Vote getVoteByUserFoodType(User user,int foodTypeId);
    void saveVote(Vote vote,User user);
    Map<Integer,Integer> getFoodVoteCountMap();

}
