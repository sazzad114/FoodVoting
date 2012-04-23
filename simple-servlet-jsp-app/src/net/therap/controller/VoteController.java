package net.therap.controller;

import net.therap.domain.Food;
import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.domain.Vote;
import net.therap.service.FoodTypeService;
import net.therap.service.FoodTypeServiceImpl;
import net.therap.service.VoteService;
import net.therap.service.VoteServiceImpl;
import org.apache.jasper.util.Enumerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class VoteController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(VoteController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VoteService voteService = new VoteServiceImpl();
        FoodType foodType = new FoodType();
        Food food = new Food();
        Vote vote = new Vote();
        String foodTypeName = null;
        Enumeration enumerator = request.getParameterNames();

        while (enumerator.hasMoreElements()) {
            foodTypeName = (String)enumerator.nextElement();
            foodType.setFoodTypeName(foodTypeName);
            food.setFoodName(request.getParameter(foodTypeName));
        }
        int foodTypeIndex= ((List<FoodType>)request.getSession().getAttribute("FOODTYPELIST")).indexOf(foodType);

        foodType = ((ArrayList<FoodType>)request.getSession().getAttribute("FOODTYPELIST")).get(foodTypeIndex);
        int foodIndex = foodType.getFoodList().indexOf(food);
        food = foodType.getFoodList().get(foodIndex);
        vote.setFood(food);
        voteService.saveVote(vote,(User)request.getSession().getAttribute("USER"));
        response.sendRedirect("/foodvoting/vote");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodTypeService foodTypeService = new FoodTypeServiceImpl();
        List<FoodType> foodTypeList = foodTypeService.getFoodTypeList((User)request.getSession().getAttribute("USER"));
        request.getSession().setAttribute("FOODTYPELIST", foodTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/vote.jsp");
        requestDispatcher.forward(request,response);

    }
}
