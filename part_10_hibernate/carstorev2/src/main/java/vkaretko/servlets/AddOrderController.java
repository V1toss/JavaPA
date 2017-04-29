package vkaretko.servlets;

import vkaretko.dao.*;
import vkaretko.models.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Class SetUserController.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class AddOrderController extends HttpServlet {
    /**
     * Get user from session.
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        //creating car
        Car car = new Car();
        car.setBody(BodyDAO.getInstance().get(Integer.valueOf(req.getParameter("bodyId"))));
        car.setTransmission(TransmissionDAO.getInstance().get(Integer.valueOf(req.getParameter("transmissionId"))));
        car.setModel(ModelDAO.getInstance().get(Integer.valueOf(req.getParameter("modelId"))));
        car.setDrive(DriveDAO.getInstance().get(Integer.valueOf(req.getParameter("driveId"))));
        car.setEngine(EngineDAO.getInstance().get(Integer.valueOf(req.getParameter("engineId"))));
        car.setEnginePower(Integer.valueOf(req.getParameter("enginePower")));
        car.setYear(Integer.valueOf(req.getParameter("year")));
        car.setMileage(Integer.valueOf(req.getParameter("mileage")));
        CarDAO.getInstance().save(car);

        //creating order
        Order order = new Order();
        order.setCar(car);
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setDescription(req.getParameter("description"));
        order.setPrice(Integer.valueOf(req.getParameter("price")));
        order.setSold(false);
        order.setUser((User)session.getAttribute("user"));

        OrderDAO.getInstance().save(order);
    }
}
