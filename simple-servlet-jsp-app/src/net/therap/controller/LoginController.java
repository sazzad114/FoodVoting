package net.therap.controller;


import net.therap.domain.User;
import net.therap.service.UserServiceImpl;
import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {



        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByUserNameAndPassword(userName,password);

        if(user == null){

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp");
            requestDispatcher.forward(request,response);

        }
        else {

            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp");
        requestDispatcher.forward(request,response);

    }


}
