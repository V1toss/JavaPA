package vkaretko.servlets;

import vkaretko.DBManager;
import vkaretko.models.Role;
import vkaretko.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Servlet for updating usera.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 07.03.2017.
 */
public class UpdateUser extends HttpServlet {
    /**
     * Passes the request for updating user to DBManager.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager.getInstance().update(new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis()),
                req.getParameter("password"), new Role(Integer.parseInt(req.getParameter("role_id")),req.getParameter("role"))));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }

    /**
     * Get old user fields for future update.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", DBManager.getInstance().searchByLogin(req.getParameter("login")));
        req.getRequestDispatcher("/WEB-INF/views/Update.jsp").forward(req, resp);
    }
}
