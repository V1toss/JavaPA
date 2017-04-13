package vkaretko.servlets;

import vkaretko.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for deleting users.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 07.03.2017.
 */
public class DeleteRole extends HttpServlet {
    /**
     * Passes the request for deleting role to DBManager.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.getInstance().deleteRole(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/edit_roles", req.getContextPath()));
    }

    /**
     * Return role (id and role name) from db.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("role", DBManager.getInstance().getRoleById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/DeleteRole.html").forward(req, resp);
    }
}
