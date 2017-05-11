package vkaretko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vkaretko.models.Order;
import vkaretko.repository.OrderDAO;

import java.util.List;

/**
 * Class UserController.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 09.05.17 15:56.
 */
@Controller
public class OrderController {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUsers(ModelMap model) {
        List<Order> orderList = (List<Order>) orderDAO.findAll();
        model.addAttribute("orders",orderList);
        return "Index";
    }
}
