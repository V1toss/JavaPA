package vkaretko.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vkaretko.domain.*;
import vkaretko.repository.*;

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
public class NewOrderController {

    private final EngineDAO engineDAO;
    private final TransmissionDAO transmissionDAO;
    private final BrandDAO brandDAO;
    private final BodyDAO bodyDAO;
    private final ModelDAO modelDAO;
    private final DriveDAO driveDAO;

    @Autowired
    public NewOrderController(EngineDAO engineDAO,
                              TransmissionDAO transmissionDAO,
                              BrandDAO brandDAO,
                              BodyDAO bodyDAO,
                              ModelDAO modelDAO,
                              DriveDAO driveDAO) {
        this.engineDAO = engineDAO;
        this.transmissionDAO = transmissionDAO;
        this.brandDAO = brandDAO;
        this.bodyDAO = bodyDAO;
        this.modelDAO = modelDAO;
        this.driveDAO = driveDAO;
    }

    @RequestMapping(value = "/neworder", method = RequestMethod.GET)
    public String loadCarProperties(ModelMap model) {

        List<Engine> engines = (List<Engine>) engineDAO.findAll();
        model.addAttribute("engines", engines);

        List<Transmission> transmissions = (List<Transmission>) transmissionDAO.findAll();
        model.addAttribute("transmissions", transmissions);

        List<Brand> brands = (List<Brand>) brandDAO.findAll();
        model.addAttribute("brands", brands);

        List<Model> models = (List<Model>) modelDAO.findAll();
        model.addAttribute("models", models);

        List<Drive> drives = (List<Drive>) driveDAO.findAll();
        model.addAttribute("drives", drives);

        List<Body> bodies = (List<Body>) bodyDAO.findAll();
        model.addAttribute("bodies", bodies);

        return "new";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(ModelMap model) {
        //todo
        return "redirect:/";
    }
}
