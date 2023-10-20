package com.ym.dao;

import com.ym.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO{

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public Student save(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public Student update(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        student = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return  student;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Student.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Student find(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select s from Student s");
        return query.getResultList();
    }
}
