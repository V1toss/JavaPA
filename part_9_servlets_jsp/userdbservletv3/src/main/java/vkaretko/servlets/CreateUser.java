package vkaretko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.DBManager;
import vkaretko.models.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Servlet for creating users.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 07.03.2017.
 */
public class CreateUser extends HttpServlet {
    /**
     * slf4j logger for UserDB servlet class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CreateUser.class);

    /**
     * DataSource for generating connections.
     */
    private DataSource ds;

    /**
     * Init datasource for generating connections.
     * @throws ServletException when init failed.
     */
    @Override
    public void init() throws ServletException {
        try {
            this.ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/users");
        } catch (NamingException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Passes the request for creating user to DBManager.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            DBManager.getInstance().add(new User(req.getParameter("name"), req.getParameter("login"),
                    req.getParameter("email"), new Timestamp(System.currentTimeMillis())), ds.getConnection());
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
