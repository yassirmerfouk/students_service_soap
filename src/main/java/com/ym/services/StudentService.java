package com.ym.services;

import com.ym.dao.IStudentDAO;
import com.ym.models.Student;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@WebService
public class StudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @WebMethod
    public Student addStudent(Student student){
        student.setId(null);
        return studentDAO.save(student);
    }

    @WebMethod
    public  Student updateStudent(Student student){
        return  studentDAO.update(student);
    }

    @WebMethod
    public void deleteStudent(@WebParam Long id){
        studentDAO.delete(id);
    }

    @WebMethod
    public Student getStudent(@WebParam Long id){
        return  studentDAO.find(id);
    }

    @WebMethod
    public List<Student> getAllStudents(){
        return studentDAO.findAll();
    }
}
