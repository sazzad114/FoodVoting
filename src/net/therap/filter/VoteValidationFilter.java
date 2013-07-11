package net.therap.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/23/12
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */

public class VoteValidationFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        if(httpServletRequest.getParameterMap().size() == 0 && httpServletRequest.getMethod().equalsIgnoreCase("POST")){
           ((HttpServletResponse)response).sendRedirect("/foodvoting/vote");
        }
        else
        {
            chain.doFilter(request,response);
        }

    }

    public void destroy() {
    }
}
