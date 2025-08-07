package com.niit.mms.learning_api.service;

import com.niit.mms.learning_api.entity.Student;
import com.niit.mms.learning_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;

    public StudentServiceImpl (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.findById(id).map(existing -> {

                existing.setFirstName(existing.getFirstName());
                existing.setMiddleName(existing.getMiddleName());
                existing.setLastName(existing.getLastName());
                existing.setPhone(existing.getPhone());

                return studentRepository.save(existing);
            }
        ).orElse(null);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAllStudents(Long id, Student student) {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
