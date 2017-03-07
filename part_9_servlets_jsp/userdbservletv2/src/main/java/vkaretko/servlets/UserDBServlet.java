package vkaretko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.DBManager;
import vkaretko.models.User;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Class UserDBServlet - CRUD operations with DB using Put, Get, Post, Delete.
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
     * DataSource for generating connections
     */
    private DataSource ds;

    /**
     * DNManager;
     */
    private final DBManager dbMan = new DBManager();

    /**
     * Connect to DB on load.
     * @throws ServletException when init failed.
     */
    @Override
    public void init() throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            this.ds = (javax.sql.DataSource) initialContext.lookup("java:comp/env/jdbc/users");
        } catch (NamingException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
            try {
                for (User user : dbMan.getAll(ds.getConnection())) {
                    writer.append(user.toString());
                    writer.append("<br/>");
                    writer.flush();
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            dbMan.add(new User(req.getParameter("name"), req.getParameter("login"),
                    req.getParameter("email"), new Timestamp(System.currentTimeMillis())), ds.getConnection());
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            dbMan.update(new User(req.getParameter("name"), req.getParameter("login"),
                    req.getParameter("email"), new Timestamp(System.currentTimeMillis())), ds.getConnection());
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            dbMan.delete(req.getParameter("login"), ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
