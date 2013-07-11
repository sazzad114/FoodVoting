package net.therap.service;

import net.therap.dao.VoteDao;
import net.therap.dao.VoteDaoImpl;
import net.therap.domain.User;
import net.therap.domain.Vote;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class VoteServiceImpl implements VoteService{
    VoteDao voteDao;
    public VoteServiceImpl(){
      voteDao = new VoteDaoImpl();
    }


    public void saveVote(Vote vote, User user) {
        voteDao.saveVote(vote,user);
    }
}
