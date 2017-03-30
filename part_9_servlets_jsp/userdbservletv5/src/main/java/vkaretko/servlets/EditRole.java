package vkaretko.servlets;

import vkaretko.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EditRole servlet.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 31.03.2017.
 */
public class EditRole extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", DBManager.getInstance().getRoles());
        req.getRequestDispatcher("/WEB-INF/views/EditRole.jsp").forward(req, resp);
    }
}
