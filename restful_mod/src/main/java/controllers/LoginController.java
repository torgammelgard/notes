package controllers;

import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {

        User user = new User();
        model.put("userForm", user);

        return "loginpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {

        User user = new User();
        model.put("userForm", user);

        return "loginpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String tryToLogin(@ModelAttribute("userForm") User user) {

        System.out.println(user.getName());

        // if the user exists in the database
        if (usersDao.isUser(user.getName())) {
            // login the user
            return "page1";
        } else {
            // go back to the login page
            return "loginpage";
        }
    }
}
