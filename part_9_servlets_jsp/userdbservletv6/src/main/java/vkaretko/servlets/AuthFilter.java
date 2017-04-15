package vkaretko.servlets;

import vkaretko.DBManager;
import vkaretko.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Authorization filter.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 27.03.2017.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("/login.html") || session.getAttribute("user") != null) {
            chain.doFilter(req, resp);
        } else if (session.getAttribute("user") == null && req.getParameter("login") == null) {
            ((HttpServletResponse) resp).sendRedirect(String.format("%s/login.html", request.getContextPath()));
        } else {
            User user = DBManager.getInstance().getUser(req.getParameter("login"), req.getParameter("password"));
            session.setAttribute("user", user);
            session.setAttribute("login", req.getParameter("login"));
            session.setAttribute("password", req.getParameter("password"));
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}

