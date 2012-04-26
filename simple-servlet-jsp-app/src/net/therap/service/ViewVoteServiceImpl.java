package net.therap.service;

import net.therap.dao.VoteDao;
import net.therap.dao.VoteDaoImpl;
import net.therap.domain.Vote;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewVoteServiceImpl implements ViewVoteService{
    VoteDao voteDao;

    public ViewVoteServiceImpl()
    {
        voteDao = new VoteDaoImpl();
    }
    public Map<Integer,Integer> getFoodVoteCountMap() {

         //return voteDao.getFoodVoteCountMap();
        return voteDao.getFoodVoteCountMap();
    }
}
