package vkaretko.servlets;

import vkaretko.dao.OrderDAO;
import vkaretko.models.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class UpdateSoldStatusController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 20.04.2017.
 */
public class UpdateSoldStatusController extends HttpServlet {
    /**
     * Update status of order in db.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = OrderDAO.getInstance().get(Integer.valueOf(req.getParameter("id")));
        order.setSold(!Boolean.valueOf(req.getParameter("isSold")));
        OrderDAO.getInstance().update(order);
    }
}
