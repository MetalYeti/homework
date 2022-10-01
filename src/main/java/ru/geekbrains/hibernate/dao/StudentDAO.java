package ru.geekbrains.hibernate.dao;

import ru.geekbrains.hibernate.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    Optional<Student> getById(Long id);

    List<Student> getAll();

    void insert(Student student);

    void delete(Student student);

    void update(Student student);
}
