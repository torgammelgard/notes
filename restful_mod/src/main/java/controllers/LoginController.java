package controllers;

import dao.NotesDao;
import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private NotesDao notesDao;

    @RequestMapping
    public String rootPage() {
        return "redirect:/root";
    }

    @RequestMapping(value = "/root")
    public String showRoot(Model model, HttpServletRequest request) {

        String username = request.getRemoteUser();
        User user = usersDao.getUser(username);
        model.addAttribute("user", user);

        return "root";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginpage";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/loggedout";
    }

    @RequestMapping(value = "/loggedout")
    public String loggedout() {
        return "loggedout";
    }

}
