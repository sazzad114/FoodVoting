package net.therap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/22/12
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class LogoutController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        HttpSession httpSession = request.getSession(false);
        if( httpSession == null){

            log.debug("Session is NULL");

        }
        response.sendRedirect("/foodvoting/login");

    }
}
