package com.oopswing.forms.groups;

import com.oopswing.App;
import com.oopswing.models.entities.Group;
import com.oopswing.services.GroupService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupsView implements ActionListener {
    private JPanel panel;
    private JButton groupsShow;
    private JButton backButton;
    private JList<Group> groupList;
    private JButton addGroup;

    public static GroupsView instance;
    private JFrame frame;

    private final GroupService groupService = new GroupService();

    public static GroupsView getInstance() {
        if (instance == null)
            instance = new GroupsView();
        return instance;
    }

    private GroupsView() {
        frame = new JFrame("Groups");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        DefaultListModel<Group> groups = new DefaultListModel<>();
        groups.addAll(groupService.findAll());
        groupList.setModel(groups);

        addGroup.addActionListener(e -> {
            AddGroupView addGroupView = new AddGroupView(frame);
        });

        groupsShow.addActionListener(this);
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
        DefaultListModel<Group> groups = new DefaultListModel<>();
        groups.addAll(groupService.findAll());
        groupList.setModel(groups);
    }
}
