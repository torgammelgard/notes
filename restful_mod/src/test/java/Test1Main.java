import dao.Note;
import dao.NotesDao;
import dao.User;
import dao.UsersDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

        UsersDao usersDao = ((UsersDao) context.getBean("usersDao")); // bean string is case sensitive

        User user = usersDao.getUser("Foo Foo 1");

        if (user != null) {
            for (Note note : user.getNotes())
                System.out.println(note.getContent());
        }

        NotesDao notesDao = ((NotesDao) context.getBean("notesDao"));

        notesDao.deleteNote(1);
    }
}
