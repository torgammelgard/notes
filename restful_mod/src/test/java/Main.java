import dao.User;
import dao.UsersDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] arsg) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

        UsersDao usersDao = ((UsersDao) context.getBean("usersDao"));

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


    }
}
