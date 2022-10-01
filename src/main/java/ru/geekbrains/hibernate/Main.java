package ru.geekbrains.hibernate;

import ru.geekbrains.hibernate.dao.StudentDAO;
import ru.geekbrains.hibernate.dao.StudentDAOImpl;
import ru.geekbrains.hibernate.entity.Student;

public class Main {

    public static void main(String[] args) {
        try {
            StudentDAO studentDAO = new StudentDAOImpl(SessionFactoryProvider.getSessionFactory());

            for (int i = 0; i < 1000; i++) {
                studentDAO.insert(new Student("Student " + i, (int) (Math.random() * 5.0) + 1));
            }

            System.out.println(studentDAO.getAll());
            Student student = studentDAO.getById(582L).orElseThrow();
            System.out.println(student);
            //studentDAO.delete(studentDAO.getById(582L).get());
            student.setName("Peter");
            studentDAO.update(student);
            System.out.println(studentDAO.getById(582L).orElseThrow());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
