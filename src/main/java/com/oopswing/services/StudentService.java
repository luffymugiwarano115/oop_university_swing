package com.oopswing.services;

import com.oopswing.models.entities.Student;
import com.oopswing.repositories.impl.StudentRepository;

import java.util.List;

public class StudentService {
    private static StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public void persist(Student entity) {
        studentRepository.openCurrentSessionwithTransaction();
        studentRepository.persist(entity);
        studentRepository.closeCurrentSessionwithTransaction();
    }

    public void update(Student entity) {
        studentRepository.openCurrentSessionwithTransaction();
        studentRepository.update(entity);
        studentRepository.closeCurrentSessionwithTransaction();
    }

    public Student findById(int id) {
        studentRepository.openCurrentSession();
        Student distribution = studentRepository.findById(id);
        studentRepository.closeCurrentSession();
        return distribution;
    }

    public void delete(int id) {
        studentRepository.openCurrentSessionwithTransaction();
        Student distribution = studentRepository.findById(id);
        studentRepository.delete(distribution);
        studentRepository.closeCurrentSessionwithTransaction();
    }

    public List<Student> findAll() {
        studentRepository.openCurrentSession();
        List<Student> distributions = studentRepository.findAll();
        studentRepository.closeCurrentSession();
        return distributions;
    }

    public void deleteAll() {
        studentRepository.openCurrentSessionwithTransaction();
        studentRepository.deleteAll();
        studentRepository.closeCurrentSessionwithTransaction();
    }
}
