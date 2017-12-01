package view;

import controller.TaskManagerController;
import model.TaskManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerViewImpl implements TaskManagerView, Observer{

    private  final TaskManagerController controller;
    private  final TaskManagerModel model;

    private  final JPanel viewPanel;
    private  final JFrame viewFrame;
    private  final JTextField viewTextName;
    private  final JTextField viewTextLastName;
    private  final JTextField viewTextPost;
    private  final JTextField viewTextConsole;
    private  final JTextField viewTextTName;
    private  final JTextField viewTextDescription;
    private  final JTextField viewTextDeadline;
    private  final JTextField viewTextPriority;
    private  final JTextField viewTextStatus;
    private  final JTextField viewTextSubTask;
    private  final JButton viewButton;


    public void createView () {

        viewPanel.add(viewTextName);
        viewPanel.add(viewTextLastName);
        viewPanel.add(viewTextPost);
        viewPanel.add(viewTextTName);
        viewPanel.add(viewTextDescription);
        viewPanel.add(viewTextDeadline);
        viewPanel.add(viewTextPriority);
        viewPanel.add(viewTextStatus);
        viewPanel.add(viewTextSubTask);
        viewPanel.add(viewTextConsole);
        viewPanel.add(viewButton);
        viewFrame.add(viewPanel);

        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.addAssignee(String.valueOf(viewTextName.getText()), String.valueOf(viewTextLastName.getText()), String.valueOf(viewTextPost.getText()));
                    controller.addTask(String.valueOf(viewTextTName.getText()),String.valueOf(viewTextDescription.getText()), String.valueOf(viewTextDeadline.getText()),String.valueOf(viewTextPriority.getText()), String.valueOf(viewTextStatus.getText()), String.valueOf(viewTextSubTask.getText()));
                } catch (RuntimeException e1) {
                    System.out.println(e1);
                }
            }
        });
    }


    public TaskManagerViewImpl(TaskManagerController controller, TaskManagerModel model) {
        this.controller = controller;
        this.model = model;

        String textViewFrame = "view";
        String textViewButton = "Ok";
        String textName = "Name";
        String textLastName = "Last Name";
        String textConsole = "Console";
        String textPost = "Post";
        String texTName = "TaskName";
        String textDescription = "Description";
        String textDeadline = "Deadline";
        String textPriority = "Priority";
        String textStatus = "Status";
        String textSubtasks = "Subtasks";


        viewFrame = new JFrame(textViewFrame);
        viewFrame.setSize(new Dimension(700, 700));

        viewPanel = new JPanel();
        viewPanel.setSize(new Dimension(700, 700));

        viewButton = new JButton(textViewButton);
        viewButton.setSize(new Dimension(100, 100));


        viewTextDeadline = new JTextField(textDeadline);
        viewTextDeadline.setSize(new Dimension(100, 100));
        viewTextPriority = new JTextField(textPriority);
        viewTextPriority.setSize(new Dimension(100, 100));
        viewTextStatus = new JTextField(textStatus);
        viewTextStatus.setSize(new Dimension(100, 100));
        viewTextSubTask = new JTextField(textSubtasks);
        viewTextSubTask.setSize(new Dimension(100, 100));
        viewTextDescription = new JTextField(textDescription);
        viewTextDescription.setSize(new Dimension(100, 100));
        viewTextTName = new JTextField(texTName);
        viewTextTName.setSize(new Dimension(100, 100));
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

    public void updateViewTextConsole(String textConsole) {
        viewTextConsole.setText(textConsole);
    }

    public String displayText () {
        return viewTextConsole.getText();
    }

    public void displayModels(){
        for (int i=0;i<model.getAssignees().size();i++){
            System.out.println(model.getAssignees().get(i).getName()+" "+
                    model.getAssignees().get(i).getLastname()+" "+
                    model.getAssignees().get(i).getPost()
            );

        }
        for (int i=0;i<model.getTasks().size();i++){
            System.out.println(model.getTasks().get(i).getT_name()+" "+
                    model.getTasks().get(i).getDescription()+" "+
                    model.getTasks().get(i).getDeadline()+" "+
                    model.getTasks().get(i).getPriority()+" "+
                    model.getTasks().get(i).getStatus()+" "+
                    model.getTasks().get(i).getSubtask()
            );

        }
    }


}
