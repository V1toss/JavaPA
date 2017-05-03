package vkaretko.servlets;

import vkaretko.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class SetPriceFilterController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 03.05.2017.
 */
public class SetPriceFilterController extends HttpServlet {
    /**
     * Get user from session.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer price = Integer.valueOf(req.getParameter("price"));
        Boolean filter = Boolean.valueOf(req.getParameter("filter"));
        if (filter) {
            OrderDAO.getInstance().setPriceFilter(price);
        } else {
            OrderDAO.getInstance().setPriceFilter(filter);
        }

    }
}
