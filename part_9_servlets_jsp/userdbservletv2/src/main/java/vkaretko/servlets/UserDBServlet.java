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
     * DataSource for generating connections.
     */
    private DataSource ds;

    /**
     * DNManager.
     */
    private final DBManager dbMan = new DBManager();

    /**
     * Init datasource for generating connections.
     * @throws ServletException when init failed.
     */
    @Override
    public void init() throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            this.ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/users");
        } catch (NamingException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Method draw form with list of users from database and links for update,create and delete records.
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
                    + "<h3>List of users</h3>"
                    + "<table border=\"1\">"
                    + "<tr>\n"
                    + "    <th>Name</th>\n"
                    + "    <th>Login</th>\n"
                    + "    <th>Email</th>\n"
                    + "    <th>Create date</th>\n"
                    + "</tr>"
            );
            try {
                for (User user : dbMan.getAll(ds.getConnection())) {
                    String urlDel = String.format("<a href=%s/delete?login=%s>Delete</a>", req.getContextPath(), user.getLogin());
                    String urlUpd = String.format("<a href=%s/update?login=%s&name=%s&email=%s>Update</a>",
                            req.getContextPath(), user.getLogin(), user.getName(), user.getEmail());
                    writer.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                            user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate(), urlDel, urlUpd));
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
            writer.append("</table>\n");
            writer.append(String.format("<a href='%s'>Add new user</a>", req.getContextPath() + "/create"));
            writer.append("</body>\n</html>");
        }
    }
}
