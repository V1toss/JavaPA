package vkaretko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.DBManager;
import vkaretko.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class UserDBServlet extends HttpServlet {
    /**
     * slf4j logger for UserDB servlet class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserDBServlet.class);

    /**
     * DBManager for servlet.
     */
    private DBManager dbMan;


    @Override
    public void init() throws ServletException {
        this.dbMan = new DBManager();
        dbMan.loadProperties();
        dbMan.connectToDB();
    }

    @Override
    public void destroy() {
        dbMan.disconnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
            for (User user : dbMan.getAll()) {
                writer.append(user.toString());
                writer.flush();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        dbMan.add(new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        dbMan.update(new User(req.getParameter("name"), req.getParameter("login"),
                req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        dbMan.delete(req.getParameter("login"));
    }
}
