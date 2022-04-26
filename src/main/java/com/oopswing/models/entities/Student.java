package com.oopswing.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student extends AbstractId {
    private String firstName;
    private String lastName;
    private float grade;
    private String facultyNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public Student() {
    }

    public Student(String firstName, String lastName, float grade, String facultyNumber, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.facultyNumber = facultyNumber;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", group=" + group.getName() +
                '}';
    }
}
