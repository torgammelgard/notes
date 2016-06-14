package controllers;

import dao.Note;
import dao.NotesDao;
import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private NotesDao notesDao;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {

        List<User> users = usersDao.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("message", "Message from /api");

        return "index";
    }

    @RequestMapping(path = "/createnote", method = RequestMethod.GET)
    public String createNote(Model model) {

        Note note = new Note();
        model.addAttribute("noteForm", note);

        return "createNote";
    }

    @RequestMapping(path = "/createnote", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute Note note, HttpServletRequest request) {

        User user = usersDao.getUser(request.getRemoteUser());
        note.setUser(user);
        notesDao.createNote(note);

        return "noteCreatedCompleted";
    }

}
