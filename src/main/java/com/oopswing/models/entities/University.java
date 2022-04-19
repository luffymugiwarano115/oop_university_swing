package com.oopswing.models.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class University extends AbstractId {
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private List<Group> groups = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private List<Teacher> teachers = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    public University(String name, List<Group> groups, List<Teacher> teachers, List<Student> students) {
        this.name = name;
        this.groups = groups;
        this.teachers = teachers;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + groups.stream().map(Group::getName).toList() +
                ", teachers=" + teachers.stream().map(teacher -> teacher.getFirstName() + " " + teacher.getLastName()).toList() +
                ", students=" + students.stream().map(student -> student.getFirstName() + " " + student.getLastName()) +
                '}';
    }
}
