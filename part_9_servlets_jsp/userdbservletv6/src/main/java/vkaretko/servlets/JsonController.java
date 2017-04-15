package vkaretko.servlets;

import vkaretko.DBManager;
import vkaretko.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JsonController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.04.2017.
 */
public class JsonController extends HttpServlet {
    /**
     * .
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.valueOf(session.getAttribute("user") != null));
        writer.flush();
    }
}
