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

public class LoginRedirectFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)request).getSession(false);

        if (session != null && session.getAttribute("USER") != null) {
            log.debug("user is not logged in");
            ((HttpServletResponse)response).sendRedirect("/foodvoting/welcome");
        } else {
             log.debug("user is logged in");
             chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
