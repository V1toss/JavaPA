package vkaretko.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class EchoServlet.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 26.02.2017.
 */
public class EchoServlet extends HttpServlet {
    /**
     * Logger for class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
             writer.append("Hello world");
             writer.flush();
        }
    }
}
