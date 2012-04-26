package net.therap.service;

import net.therap.domain.Vote;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ViewVoteService {
    Map<Integer,Integer> getFoodVoteCountMap();
}
