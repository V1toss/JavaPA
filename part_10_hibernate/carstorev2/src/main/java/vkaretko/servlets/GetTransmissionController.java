package vkaretko.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import vkaretko.dao.TransmissionDAO;
import vkaretko.models.Transmission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class GetTransmissionController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class GetTransmissionController extends HttpServlet {
    /**
     * Get list of transmissions from TransmissionDAO.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        List<Transmission> brands = TransmissionDAO.getInstance().getAll();
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(brands));
        writer.flush();
    }
}
