package com.oopswing.forms.students;

import com.oopswing.App;
import com.oopswing.services.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsView implements ActionListener {
    private JPanel panel;
    private JButton studentsShow;
    private JButton backButton;

    public static StudentsView instance;
    private JFrame frame;

    public static StudentsView getInstance() {
        if (instance == null)
            instance = new StudentsView();
        return instance;
    }

    private StudentsView() {
        frame = new JFrame("Students");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        studentsShow.addActionListener(this);
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            App.getInstance().getFrameInstance().setVisible(true);
        });
    }

    public JFrame getFrameInstance() {
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentService studentService = new StudentService();
        studentService.findAll();
    }
}
