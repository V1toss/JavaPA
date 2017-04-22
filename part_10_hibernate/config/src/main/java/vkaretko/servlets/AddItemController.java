package vkaretko.servlets;

import vkaretko.ItemDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class AddItemController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 20.04.2017.
 */
public class AddItemController extends HttpServlet {
    /**
     * Add new item to db.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDAOImpl.getInstance().addItem(req.getParameter("desc"));
    }
}
