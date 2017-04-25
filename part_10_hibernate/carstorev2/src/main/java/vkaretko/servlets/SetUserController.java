package vkaretko.servlets;

import vkaretko.dao.UserDAO;
import vkaretko.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class SetUserController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class SetUserController extends HttpServlet {
    /**
     * Get user from session.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<User> users = UserDAO.getInstance().getAll();
        session.setAttribute("user", null);
        for (User user : users) {
            if (user != null && user.getLogin().equals(req.getParameter("login"))
                    && user.getPassword().equals(req.getParameter("password"))) {
                session.setAttribute("user", user);
                break;
            }
        }
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.valueOf(session.getAttribute("user") != null));
        writer.flush();
    }
}
