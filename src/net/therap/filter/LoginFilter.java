package net.therap.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author misbah
 */

public class LoginFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)request).getSession(false);


        if (session == null || session.getAttribute("USER") == null || session.getAttribute("isLoggedIn") == null) {
            log.debug("log test");
            ((HttpServletResponse)response).sendRedirect("/foodvoting/login");
        } else {
             log.debug("user is logged in but how");
             chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
