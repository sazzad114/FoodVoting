package net.therap.dao;


import net.therap.domain.User;
import net.therap.domain.Vote;
import net.therap.util.DatabaseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class VoteDaoImpl implements VoteDao{

    private static final Logger log = LoggerFactory.getLogger(VoteDaoImpl.class);
    DatabaseTemplate dbTemplate;

    public VoteDaoImpl(){

        dbTemplate = new DatabaseTemplate();
    }

    public Vote getVoteByUserFoodType(User user, int foodTypeId) {


        String query = "SELECT * FROM ASH_SAZ_USER_FOOD_VOTE WHERE FOOD_TYPE_ID = ? AND USER_ID = ? AND VOTING_DATE = ?";
        log.debug(" "+foodTypeId+" "+ user.getId()+"before date" + new Date());
        Date date = new Date();
        List<Vote> voteList = dbTemplate.queryForObject(new RowVoteMapperImpl(),query,foodTypeId,user.getId(),date);
        log.debug(" "+foodTypeId+" "+ user.getId()+"after date access");
        if(voteList.size() == 0){
            //log.debug("return null for" + foodTypeId);
            return null;
        }
        else {
            return voteList.get(0);
        }
    }

    public void saveVote(Vote vote, User user) {

        String query = "INSERT INTO ASH_SAZ_USER_FOOD_VOTE VALUES(SEQ_ASH_SAZ_USER_FOOD_VOTE.nextval,?,?,?,?)";
        dbTemplate.executeInsertQuery(query,new Date(),user.getId(),vote.getFood().getFoodId(),vote.getFood().getFoodTypeId());

    }

    public Map<Integer,Integer> getFoodVoteCountMap() {
        Map<Integer, Integer> map;
        String query = "SELECT FOOD_ID, COUNT(*) as VOTE_NUM FROM ASH_SAZ_USER_FOOD_VOTE GROUP BY VOTING_DATE,FOOD_ID HAVING VOTING_DATE = ?" ;
        Date date = new Date();
        map = dbTemplate.queryForObjectMap(new ResultsetMapMapperImpl(),query,date);
        return map;
    }
}
