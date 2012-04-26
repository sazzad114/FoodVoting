package net.therap.controller;


import net.therap.domain.FoodType;
import net.therap.domain.User;
import net.therap.service.FoodTypeService;
import net.therap.service.FoodTypeServiceImpl;
import net.therap.service.UserServiceImpl;
import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LoginController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {



        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByUserNameAndPassword(userName,password);

        if(user == null){
            String unsuccessfulLogin = "loginerror";
            response.sendRedirect("/foodvoting/login?message="+unsuccessfulLogin);

        }
        else {

            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            FoodTypeService foodTypeService = new FoodTypeServiceImpl();
            List<FoodType> foodTypeList = foodTypeService.getFoodTypeList((User)request.getSession().getAttribute("USER"));

            request.getSession().setAttribute("isLoggedIn",true);
            log.debug(user.isAdmin()+"user type");
            request.getSession().setAttribute("FOODTYPELIST", foodTypeList);
            response.sendRedirect("/foodvoting/welcome");

        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        log.debug("login get");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp");
        requestDispatcher.forward(request,response);

    }


}
