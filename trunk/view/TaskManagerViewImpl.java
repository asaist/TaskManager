package view;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerViewImpl implements TaskManagerView, Observer{

    private  final TaskManagerControllerImpl controller;
    private  final AssigneeImpl model;

    private  final JPanel viewPanel;
    private  final JFrame viewFrame;
    private  final JTextField viewTextName;
    private  final JTextField viewTextLastName;
    private  final JTextField viewTextPost;
    private  final JTextField viewTextConsole;
    private  final JButton viewButton;


    public void createView () {




        viewPanel.add(viewTextName);
        viewPanel.add(viewTextLastName);
        viewPanel.add(viewTextPost);
        viewPanel.add(viewTextConsole);
        viewPanel.add(viewButton);

        viewFrame.add(viewPanel);

        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.assigneeImplSetName(String.valueOf(viewTextName.getText()));
            }
        });
    }


    public TaskManagerViewImpl(TaskManagerControllerImpl controller, AssigneeImpl model) {
        this.controller = controller;
        this.model = model;

        String textViewFrame = "view";
        String textViewButton = "Ok";
        String textName = "Name";
        String textLastName = "Last Name";
        String textConsole = "Console";
        String textPost = "Post";


        viewFrame = new JFrame(textViewFrame);
        viewFrame.setSize(new Dimension(700, 700));

        viewPanel = new JPanel();
        viewPanel.setSize(new Dimension(700, 700));

        viewButton = new JButton(textViewButton);
        viewButton.setSize(new Dimension(100, 100));

        viewTextName = new JTextField(textName);
        viewTextName.setSize(new Dimension(100, 100));
        viewTextLastName = new JTextField(textLastName);
        viewTextLastName.setSize(new Dimension(100, 100));
        viewTextPost = new JTextField(textPost);
        viewTextPost.setSize(new Dimension(100, 100));
        viewTextConsole = new JTextField(textConsole);
        viewTextConsole.setSize(new Dimension(100, 100));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}