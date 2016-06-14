package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Note> getAllNotes() {
        return session().createQuery("from Note").list();
    }

}
