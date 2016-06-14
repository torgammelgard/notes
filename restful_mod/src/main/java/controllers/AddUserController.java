package controllers;

import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import dao.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/createUser")
public class AddUserController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        User user = new User();
        model.put("userForm", user);

        return "createUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAddUser(@ModelAttribute("userForm") User user, Map<String, Object> model) {

        usersDao.create(user);
        model.put("message", "User added");

        return new ModelAndView("createUserComplete", model);
    }
}
