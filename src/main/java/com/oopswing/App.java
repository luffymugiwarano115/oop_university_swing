package com.oopswing;

import com.oopswing.models.entities.Group;
import com.oopswing.models.entities.Student;
import com.oopswing.services.GroupService;
import com.oopswing.services.StudentService;
import com.oopswing.services.TeacherService;
import com.oopswing.util.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private JPanel panel;
    private JTextPane universityNameTextPane;
    private JButton studentsButton;
    private JButton teachersButton;
    private JButton groupsButton;

    public App(StudentService studentService, GroupService groupService, TeacherService teacherService) {
        studentsButton.setMinimumSize(new Dimension(250, 35));
        teachersButton.setMinimumSize(new Dimension(250, 35));
        groupsButton.setMinimumSize(new Dimension(250, 35));

        studentsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, studentService.findAll().toString());
        });
        groupsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, groupService.findAll().toString());
        });
        teachersButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, teacherService.findAll().toString());
        });
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        StudentService studentService = new StudentService();
        GroupService groupService = new GroupService();
        TeacherService teacherService = new TeacherService();
        Group group = new Group("name");
        groupService.persist(group);
        studentService.persist(new Student("firstName1", "lastName1", 5, group));
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App(studentService, groupService, teacherService).panel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setBounds(600, 200, 600, 600);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    studentService.deleteAll();
                    teacherService.deleteAll();
                    groupService.deleteAll();
                    System.exit(0);
                }
            }
        });
        session.close();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
