package vkaretko.servlets;

import vkaretko.ItemDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class DeleteItemController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 20.04.2017.
 */
public class DeleteItemController extends HttpServlet {
    /**
     * Delete item from db.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDAOImpl.getInstance().deleteItem(Integer.valueOf(req.getParameter("id")));
    }
}
