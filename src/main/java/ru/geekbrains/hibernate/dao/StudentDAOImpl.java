package ru.geekbrains.hibernate.dao;

import jakarta.persistence.Query;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.geekbrains.hibernate.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Student> getById(Long id) {
        Session session = sessionFactory.openSession();
        IdentifierLoadAccess<Student> studentIdentifierLoadAccess = session.byId(Student.class);
        return studentIdentifierLoadAccess.loadOptional(id);
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student", Student.class);

        return query.getResultList();
    }

    @Override
    public void insert(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(student);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(student);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.merge(student);

        session.getTransaction().commit();
        session.close();
    }
}
