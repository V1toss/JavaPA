package vkaretko.servlets;

import vkaretko.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for adding roles.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 01.04.2017.
 */
public class AddRole extends HttpServlet {
    /**
     * Passes the request for adding roles to DBManager.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.getInstance().addRole(req.getParameter("role"));
        resp.sendRedirect(String.format("%s/edit_roles", req.getContextPath()));
    }

    /**
     * Forward to AddRole.jsp.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AddRole.html").forward(req, resp);
    }
}
