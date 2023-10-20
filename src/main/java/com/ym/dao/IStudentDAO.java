package com.ym.dao;

import com.ym.models.Student;

import java.util.List;

public interface IStudentDAO {

    Student save(Student student);
    Student update(Student student);
    void delete(Long id);
    Student find(Long id);
    List<Student> findAll();

}
