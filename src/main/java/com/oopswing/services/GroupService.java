package com.oopswing.services;

import com.oopswing.models.entities.Group;
import com.oopswing.repositories.impl.GroupRepository;

import java.util.List;

public class GroupService {
    private static GroupRepository groupRepository;

    public GroupService() {
        groupRepository = new GroupRepository();
    }

    public void persist(Group entity) {
        groupRepository.openCurrentSessionwithTransaction();
        groupRepository.persist(entity);
        groupRepository.closeCurrentSessionwithTransaction();
    }

    public void update(Group entity) {
        groupRepository.openCurrentSessionwithTransaction();
        groupRepository.update(entity);
        groupRepository.closeCurrentSessionwithTransaction();
    }

    public Group findById(int id) {
        groupRepository.openCurrentSession();
        Group distribution = groupRepository.findById(id);
        groupRepository.closeCurrentSession();
        return distribution;
    }

    public void delete(int id) {
        groupRepository.openCurrentSessionwithTransaction();
        Group distribution = groupRepository.findById(id);
        groupRepository.delete(distribution);
        groupRepository.closeCurrentSessionwithTransaction();
    }

    public List<Group> findAll() {
        groupRepository.openCurrentSession();
        List<Group> distributions = groupRepository.findAll();
        groupRepository.closeCurrentSession();
        return distributions;
    }

    public void deleteAll() {
        groupRepository.openCurrentSessionwithTransaction();
        groupRepository.deleteAll();
        groupRepository.closeCurrentSessionwithTransaction();
    }
}
