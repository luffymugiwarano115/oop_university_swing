package com.oopswing;

import com.oopswing.forms.groups.GroupsView;
import com.oopswing.forms.students.StudentsView;
import com.oopswing.forms.teachers.TeachersView;
import com.oopswing.models.entities.University;
import com.oopswing.services.UniversityService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class App extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextPane universityNameTextPane;
    private JButton studentsButton;
    private JButton teachersButton;
    private JButton groupsButton;
    private JButton saveButton;

    public static App instance;
    private final JFrame frame;

    private final UniversityService universityService = new UniversityService();

    public static App getInstance() {
        if (instance == null)
            instance = new App();
        return instance;
    }

    private App() {
        frame = new JFrame("University");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(600, 200, 600, 600);
        frame.setVisible(true);

        universityNameTextPane.setText(universityService.findAll().stream().findFirst().orElse(new University()).getName());

        studentsButton.addActionListener(e -> {
            frame.setVisible(false);
            StudentsView.getInstance().getFrameInstance().setVisible(true);
        });

        groupsButton.addActionListener(e -> {
            frame.setVisible(false);
            GroupsView.getInstance().getFrameInstance().setVisible(true);
        });

        teachersButton.addActionListener(e -> {
            frame.setVisible(false);
            TeachersView.getInstance().getFrameInstance().setVisible(true);
        });

        saveButton.addActionListener(this);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public JFrame getFrameInstance() {
        return frame;
    }

    public static void main(String[] args) {
        getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AtomicBoolean foundUni = new AtomicBoolean(true);
        University university = universityService.findAll().stream().findFirst().orElseGet(() -> {
            foundUni.set(false);
            return new University();
        });
        university.setName(universityNameTextPane.getText());
        if (foundUni.get()) {
            universityService.update(university);
        } else {
            universityService.persist(university);
        }
    }
}
