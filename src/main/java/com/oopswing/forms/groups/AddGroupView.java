package com.oopswing.forms.groups;

import com.oopswing.models.entities.Group;
import com.oopswing.models.entities.Student;
import com.oopswing.services.StudentService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGroupView extends JDialog implements ActionListener {
    private JLabel nameLabel;
    private JLabel studentLabel;
    private JTextField groupName;
    private JComboBox<Student> studentComboBox;
    private JButton removeStudent;
    private JButton addStudent;
    private JList<Student> studentList;
    private JButton quit;
    private JButton createButton;
    private JPanel panel;

    private final StudentService studentService = new StudentService();

    public AddGroupView(JFrame frame) {
        final JDialog addDialog = new JDialog(frame, "Create group", true);

        DefaultComboBoxModel<Student> students = new DefaultComboBoxModel<>();
        students.addAll(studentService.findAll());
        studentComboBox.setModel(students);

        addDialog.setContentPane(panel);
        addDialog.setLocationRelativeTo(null);
        addDialog.pack();
        addDialog.setVisible(true);

        addStudent.addActionListener(e -> {
            Student selectedStudent = (Student) studentComboBox.getSelectedItem();
            DefaultListModel<Student> studentModel = (DefaultListModel<Student>) studentList.getModel();
            studentModel.addElement(selectedStudent);
            studentList.setModel(studentModel);
        });

        removeStudent.addActionListener(e -> {
            Student selectedStudent = studentList.getSelectedValue();
            DefaultListModel<Student> studentModel = (DefaultListModel<Student>) studentList.getModel();
            studentModel.removeElement(selectedStudent);
            studentList.setModel(studentModel);
        });

        quit.addActionListener(e -> {
            addDialog.setVisible(false);
        });

        createButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
