package controllers;

import dao.Note;
import dao.NotesDao;
import dao.User;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private NotesDao notesDao;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "apiroot";
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

    @RequestMapping(path = "/deletenote", method = RequestMethod.POST)
    public String prepareToDeleteNote(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        return "forward:/api/deletenote/" + id;
    }

    @RequestMapping(path = "/deletenote/{id}", method = RequestMethod.POST)
    public String deleteNote(@PathVariable(value = "id") int id) {
        System.out.println("deleting note" + id);
        if (notesDao.deleteNote(id)) {
            System.out.println("Deleted note with id " + id);
        } else
            System.out.println("Couldn't note with id " + id);
        return "redirect:/root";
    }
}
