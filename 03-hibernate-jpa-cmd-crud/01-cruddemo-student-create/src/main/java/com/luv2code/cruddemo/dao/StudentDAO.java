package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(int id);
    void update(Student newObject);
    void delete(int id);
}
