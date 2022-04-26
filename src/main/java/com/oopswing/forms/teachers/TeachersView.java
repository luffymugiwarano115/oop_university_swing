package com.oopswing.forms.teachers;

import com.oopswing.App;
import com.oopswing.services.TeacherService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeachersView implements ActionListener {
    private JPanel panel;
    private JButton teachersShow;
    private JButton backButton;

    public static TeachersView instance;
    private JFrame frame;

    public static TeachersView getInstance() {
        if (instance == null)
            instance = new TeachersView();
        return instance;
    }

    private TeachersView() {
        frame = new JFrame("Teachers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        teachersShow.addActionListener(this);
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
        TeacherService teacherService = new TeacherService();
        teacherService.findAll();
    }
}
