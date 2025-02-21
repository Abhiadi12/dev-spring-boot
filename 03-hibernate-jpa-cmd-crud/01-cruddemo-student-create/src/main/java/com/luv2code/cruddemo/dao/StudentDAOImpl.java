package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, 1);
    }

    @Override
    @Transactional
    public void update(Student newObject) {
        entityManager.merge(newObject);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student mystudent = findById(id);
        if (mystudent != null) {
            entityManager.remove(mystudent); // Remove entity from the database
        } 
    }

}










