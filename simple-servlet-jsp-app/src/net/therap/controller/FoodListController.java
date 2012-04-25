package net.therap.controller;

import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.service.FoodTypeService;
import net.therap.service.FoodTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("FOODTYPELIST") == null){
          FoodTypeService foodTypeService = new FoodTypeServiceImpl();
          List<FoodType> foodTypeList = foodTypeService.getFoodTypeList((User)request.getSession().getAttribute("USER"));
          request.getSession().setAttribute("FOODTYPELIST", foodTypeList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/foodlist.jsp");
        requestDispatcher.forward(request,response);
    }
}
