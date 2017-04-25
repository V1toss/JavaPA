package vkaretko.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import vkaretko.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class GetUserController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class GetUserController extends HttpServlet {
    /**
     * Get user from session.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(user));
        writer.flush();
    }
}
