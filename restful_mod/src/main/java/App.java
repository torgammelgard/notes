import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private static SessionFactory factory;

    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

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
/*

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
