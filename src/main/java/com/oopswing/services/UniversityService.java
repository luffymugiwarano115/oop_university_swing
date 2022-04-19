package com.oopswing.services;

import com.oopswing.models.entities.University;
import com.oopswing.repositories.impl.UniversityRepository;

import java.util.List;

public class UniversityService {
    private static UniversityRepository universityRepository;

    public UniversityService() {
        universityRepository = new UniversityRepository();
    }

    public void persist(University entity) {
        universityRepository.openCurrentSessionwithTransaction();
        universityRepository.persist(entity);
        universityRepository.closeCurrentSessionwithTransaction();
    }

    public void update(University entity) {
        universityRepository.openCurrentSessionwithTransaction();
        universityRepository.update(entity);
        universityRepository.closeCurrentSessionwithTransaction();
    }

    public University findById(int id) {
        universityRepository.openCurrentSession();
        University distribution = universityRepository.findById(id);
        universityRepository.closeCurrentSession();
        return distribution;
    }

    public void delete(int id) {
        universityRepository.openCurrentSessionwithTransaction();
        University distribution = universityRepository.findById(id);
        universityRepository.delete(distribution);
        universityRepository.closeCurrentSessionwithTransaction();
    }

    public List<University> findAll() {
        universityRepository.openCurrentSession();
        List<University> distributions = universityRepository.findAll();
        universityRepository.closeCurrentSession();
        return distributions;
    }

    public void deleteAll() {
        universityRepository.openCurrentSessionwithTransaction();
        universityRepository.deleteAll();
        universityRepository.closeCurrentSessionwithTransaction();
    }
}
