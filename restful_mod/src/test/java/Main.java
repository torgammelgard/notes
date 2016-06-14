import dao.Note;
import dao.NotesDao;
import dao.User;
import dao.UsersDao;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    //private static SessionFactory factory;

    public static void main(String[] arsg) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

        UsersDao usersDao = ((UsersDao) context.getBean("usersDao")); // bean string is case sensitive

        // create
        User user = new User();
        user.setName("Foo Foo 1");
        usersDao.create(user);

        // read
        List<User> users = usersDao.getAllUsers();

        for (User u : users) {
            System.out.println(u.getName());
        }

        // update


        // delete


        NotesDao notesDao = (NotesDao) context.getBean("notesDao");

        // create
        Note note = new Note();
        note.setTitle("Title");
        note.setContent("Content here");
        note.setDate(new java.util.Date());
        note.setUser(user);
        notesDao.createNote(note);

        Note note2 = new Note();
        note2.setTitle("Title 2");
        note2.setContent("Content TWO");
        note2.setDate(new java.util.Date());
        note2.setUser(user);
        notesDao.createNote(note2);

        // read
        List<Note> notes = notesDao.getAllNotes();

        for (Note n : notes) {
            System.out.println(note.getTitle() + ", " + note.getContent());
        }

        // update


        // delete


        //ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
/*
        ApplicationContext databaseContext = new ClassPathXmlApplicationContext("/config/BeanLocations.xml");
        org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = (org.springframework.jdbc.datasource.DriverManagerDataSource) databaseContext.getBean("dataSource");
        SessionFactory sessionFactory = (SessionFactory) databaseContext.getBean("sessionFactory");

        try (
                Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users")
        )
        {
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }


        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            User user = new User();
            user.setName("Tor");
            session.save(user);

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Nope");
            e.printStackTrace();
        } finally {
            factory.close();
        }
*/

    }
}
