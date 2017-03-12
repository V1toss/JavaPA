package vkaretko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.DBManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet for deleting users.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 07.03.2017.
 */
public class DeleteUser extends HttpServlet {
    /**
     * slf4j logger for UserDB servlet class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DeleteUser.class);

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
     * Method draw form with question about deleting user and submit button.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream(), true)) {
            writer.append("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <title>User Database</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h4>Are you really want to delete user "
            );
            writer.append(String.format("\"%s\"?</h4>", req.getParameter("login")));
            writer.append(String.format("<form action='%s/delete' method=post>", req.getContextPath()));
            writer.append(String.format("<input type='hidden' name='login' value='%s'/><br/>", req.getParameter("login")));
            writer.append("<input type='submit' value='Delete'/><br/>");
            writer.append("</form></body></html>");
        }
    }

    /**
     * Passes the request for deleting user to DBManager.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            DBManager.getInstance().delete(req.getParameter("login"), ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
