package View;

import Controller.TaskManagerControllerImpl;
import Model.Assignee_Impl;
import Model.Task_Impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
public class ConsoleInputImpl implements ConsoleInput, Observer{

    private  final TaskManagerControllerImpl controller;
    private  final Assignee_Impl model;

    private  final JPanel viewPanel;
    private  final JFrame viewFrame;
    private  final JTextField viewTextName;
    private  final JTextField viewTextLastName;
    private  final JTextField viewTextPost;
    private  final JButton viewButton;


    public void createView () {




        viewPanel.add(viewTextName);
        viewPanel.add(viewTextLastName);
        viewPanel.add(viewTextPost);
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


    public ConsoleInputImpl(TaskManagerControllerImpl controller, Assignee_Impl model) {
        this.controller = controller;
        this.model = model;

        String textViewFrame = "View";
        String textViewButton = "Ok";
        String textName = "Name";
        String textLastName = "Last Name";
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
    }

    Scanner scanner = new Scanner(System.in);
    public String nameInput () {
        System.out.println("Input name ");
        String nameInput = scanner.nextLine();
        return nameInput;
    }
    public String lastNameInput () {
        System.out.println("Input lastname ");
        String lastNameInput = scanner.nextLine();
        return lastNameInput;
    }
    public String postInput () {
        System.out.println("Input post ");
        String postInput = scanner.nextLine();
        return postInput;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
