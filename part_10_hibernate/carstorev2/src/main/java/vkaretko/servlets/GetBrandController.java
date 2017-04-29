package vkaretko.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import vkaretko.dao.BrandDAO;
import vkaretko.models.Brand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class GetBrandController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class GetBrandController extends HttpServlet {
    /**
     * Get list of brands from BrandDAO.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        List<Brand> brands = BrandDAO.getInstance().getAll();
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(brands));
        writer.flush();
    }
}
