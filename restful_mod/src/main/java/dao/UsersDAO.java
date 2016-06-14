package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("usersDao")
@EnableTransactionManagement
@Transactional
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return session().createQuery("from User").list();
    }

    public boolean isUser(String username) {
        Query query = session().createQuery("from User where name = :username");
        query.setParameter("username", username);
        List<User> list = query.list();
        return list.size() > 0;
    }

    public void create(User user) {
        session().save(user);
    }

}
