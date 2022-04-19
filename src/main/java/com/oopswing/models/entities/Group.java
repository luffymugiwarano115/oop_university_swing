package com.oopswing.models.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends AbstractId {
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();

    public Group() {
    }

    public Group(String name, List<Student> students, List<Teacher> teachers) {
        this.name = name;
        this.students = students;
        this.teachers = teachers;
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students.stream().map(student -> student.getFirstName() + " " + student.getLastName()).toList() +
                ", teachers=" + teachers.stream().map(teacher -> teacher.getFirstName() + " " + teacher.getLastName()).toList() +
                '}';
    }
}
