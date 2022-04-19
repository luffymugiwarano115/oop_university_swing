package com.oopswing.services;

import com.oopswing.models.entities.Teacher;
import com.oopswing.repositories.impl.TeacherRepository;

import java.util.List;

public class TeacherService {
    private static TeacherRepository teacherRepository;

    public TeacherService() {
        teacherRepository = new TeacherRepository();
    }

    public void persist(Teacher entity) {
        teacherRepository.openCurrentSessionwithTransaction();
        teacherRepository.persist(entity);
        teacherRepository.closeCurrentSessionwithTransaction();
    }

    public void update(Teacher entity) {
        teacherRepository.openCurrentSessionwithTransaction();
        teacherRepository.update(entity);
        teacherRepository.closeCurrentSessionwithTransaction();
    }

    public Teacher findById(int id) {
        teacherRepository.openCurrentSession();
        Teacher distribution = teacherRepository.findById(id);
        teacherRepository.closeCurrentSession();
        return distribution;
    }

    public void delete(int id) {
        teacherRepository.openCurrentSessionwithTransaction();
        Teacher distribution = teacherRepository.findById(id);
        teacherRepository.delete(distribution);
        teacherRepository.closeCurrentSessionwithTransaction();
    }

    public List<Teacher> findAll() {
        teacherRepository.openCurrentSession();
        List<Teacher> distributions = teacherRepository.findAll();
        teacherRepository.closeCurrentSession();
        return distributions;
    }

    public void deleteAll() {
        teacherRepository.openCurrentSessionwithTransaction();
        teacherRepository.deleteAll();
        teacherRepository.closeCurrentSessionwithTransaction();
    }
}
