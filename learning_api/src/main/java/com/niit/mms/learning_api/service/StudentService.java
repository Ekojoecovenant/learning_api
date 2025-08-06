package com.niit.mms.learning_api.service;

import com.niit.mms.learning_api.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student findStudent(Long id);

    List<Student> findAllStudents(Long id, Student student);

    void deleteStudent(Long id);
}
