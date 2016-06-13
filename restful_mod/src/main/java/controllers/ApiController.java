package controllers;

import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {

        List<User> users = usersDao.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("message", "Message from /api");

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public ModelAndView start() {
        return new ModelAndView("welcome", new ModelMap("message", "Message from /main/welcome!!!"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome/{str}")
    public ModelAndView specialWelcome(@PathVariable String str) {
        return new ModelAndView("welcome", new ModelMap("message", "Welcome : " + str));
    }
}
