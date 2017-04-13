package vkaretko.servlets;

import vkaretko.models.User;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
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
        if (request.getRequestURI().contains("/signin")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") == null) {
                ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", request.getContextPath()));
                return;
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}

