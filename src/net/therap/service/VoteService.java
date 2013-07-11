package net.therap.service;

import net.therap.domain.User;
import net.therap.domain.Vote;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VoteService {

    void saveVote(Vote vote,User user);
}
