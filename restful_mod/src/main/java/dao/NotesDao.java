package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("notesDao")
@EnableTransactionManagement
@Transactional
public class NotesDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void createNote(Note note) {
        session().save(note);
    }

    public boolean deleteNote(long id) {
        Query query = session().createQuery("delete from Note where id = :id");
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
