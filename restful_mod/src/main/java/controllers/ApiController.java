package controllers;

import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
