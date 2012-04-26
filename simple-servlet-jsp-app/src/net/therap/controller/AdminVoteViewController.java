package net.therap.controller;

import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.domain.Vote;
import net.therap.service.FoodTypeService;
import net.therap.service.FoodTypeServiceImpl;
import net.therap.service.ViewVoteService;
import net.therap.service.ViewVoteServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminVoteViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(((User)request.getSession().getAttribute("USER")).isAdmin() == false){
            response.sendRedirect("/foodvoting/welcome");
        }


        ViewVoteService viewVoteService = new ViewVoteServiceImpl();
        Map<Integer,Integer> foodIdVoteCountMap = viewVoteService.getFoodVoteCountMap();


        request.setAttribute("foodVoteCount",foodIdVoteCountMap);

        if(request.getSession().getAttribute("FOODTYPELIST") == null){
          FoodTypeService foodTypeService = new FoodTypeServiceImpl();
          List<FoodType> foodTypeList = foodTypeService.getFoodTypeList((User)request.getSession().getAttribute("USER"));
          request.getSession().setAttribute("FOODTYPELIST", foodTypeList);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewvote.jsp");
        requestDispatcher.forward(request,response);



    }
}
