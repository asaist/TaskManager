package view;

import controller.TaskManagerController;
import model.Assignee;
import model.Task;
import model.TaskManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerViewImpl implements TaskManagerView, Observer{

    private  final TaskManagerController controller;
    private  final TaskManagerModel model;

    private  final JPanel addAssaigneePanel;
    private  final JPanel addTaskPanel;
    private   JPanel TaskPanel;
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
    private  final JButton addAssaigneeButton;
    private  final JButton addTaskButton;
    private  final JButton deleteAssigneeButton;
    private  final JButton deleteTaskButton;
    private  final String textViewFrame = "view";
    private  final String addAssaigneeButtonLable = "Add Assaignee";
    private  final String addTaskButtonLable = "Add Task";
    private  final String deleteAssigneeButtonLable = "Delete Assignee";
    private  final String deleteTaskButtonLable = "Delete Task";
    private  final String textName = "Name";
    private  final String textLastName = "Last Name";
    private  final String textConsole = "Console";
    private  final String textPost = "Post";
    private  final String texTName = "TaskName";
    private  final String textDescription = "Description";
    private  final String textDeadline = "Deadline";
    private  final String textPriority = "Priority";
    private  final String textStatus = "Status";
    private  final String textSubtasks = "Subtasks";



    public TaskManagerViewImpl(TaskManagerController controller, TaskManagerModel model) {
        this.controller = controller;
        this.model = model;

        viewFrame = new JFrame(textViewFrame);
        addAssaigneePanel = new JPanel();
        addTaskPanel = new JPanel();

        addAssaigneeButton = new JButton(addAssaigneeButtonLable);
        addTaskButton = new JButton(addTaskButtonLable);
        deleteAssigneeButton = new JButton(deleteAssigneeButtonLable);
        deleteTaskButton = new JButton(deleteTaskButtonLable);

        viewTextName = new JTextField(textName);
        viewTextLastName = new JTextField(textLastName);
        viewTextPost = new JTextField(textPost);
        viewTextConsole = new JTextField(textConsole);

        viewTextTName = new JTextField(texTName);
        viewTextDescription = new JTextField(textDescription);
        viewTextDeadline = new JTextField(textDeadline);
        viewTextPriority = new JTextField(textPriority);
        viewTextStatus = new JTextField(textStatus);
        viewTextSubTask = new JTextField(textSubtasks);
    }

    public void createView () {

        viewFrame.pack();
        viewFrame.setSize(700, 700);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        viewFrame.setVisible(true);

        addAssaigneePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addAssaigneePanel.setSize(new Dimension(700, 700));

        addAssaigneePanel.add(viewTextName);
        addAssaigneePanel.add(viewTextLastName);
        addAssaigneePanel.add(viewTextPost);
        addAssaigneePanel.add(viewTextConsole);
        addAssaigneePanel.add(addAssaigneeButton);
        addAssaigneePanel.add(deleteAssigneeButton);

        viewTextName.setSize(new Dimension(100, 100));
        viewTextLastName.setSize(new Dimension(100, 100));
        viewTextPost.setSize(new Dimension(100, 100));
        viewTextConsole.setSize(new Dimension(100, 100));
        addAssaigneeButton.setSize(new Dimension(100, 100));
        deleteAssigneeButton.setSize(new Dimension(100, 100));

        viewFrame.add(addAssaigneePanel);



        addTaskPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addTaskPanel.setSize(new Dimension(700, 700));

        addTaskPanel.add(viewTextTName);
        addTaskPanel.add(viewTextDescription);
        addTaskPanel.add(viewTextDeadline);
        addTaskPanel.add(viewTextPriority);
        addTaskPanel.add(viewTextStatus);
        addTaskPanel.add(viewTextSubTask);
        addTaskPanel.add(addTaskButton);
        addTaskPanel.add(deleteTaskButton);

        viewTextTName.setSize(new Dimension(100, 100));
        viewTextDescription.setSize(new Dimension(100, 100));
        viewTextDeadline.setSize(new Dimension(100, 100));
        viewTextPriority.setSize(new Dimension(100, 100));
        viewTextStatus.setSize(new Dimension(100, 100));
        viewTextSubTask.setSize(new Dimension(100, 100));
        addTaskButton.setSize(new Dimension(100, 100));
        deleteTaskButton.setSize(new Dimension(100, 100));

        viewFrame.add(addTaskPanel);


        addAssaigneeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.addAssignee(String.valueOf(viewTextName.getText()), String.valueOf(viewTextLastName.getText()), String.valueOf(viewTextPost.getText()));
                String fileName = String.valueOf(viewTextName.getText()) + " " + String.valueOf(viewTextLastName.getText()) + " " + String.valueOf(viewTextPost.getText());
                fileWriter(fileName);
            } catch (RuntimeException e1) {
                System.out.println(e1);
            }
        }
    });
                addTaskButton.addActionListener(new TaskActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            controller.addTask(String.valueOf(viewTextTName.getText()),String.valueOf(viewTextDescription.getText()), String.valueOf(viewTextDeadline.getText()),String.valueOf(viewTextPriority.getText()), String.valueOf(viewTextStatus.getText()), String.valueOf(viewTextSubTask.getText()));
                            String fileName = String.valueOf(viewTextTName.getText()) + " " + String.valueOf(viewTextDescription.getText()) + " " + String.valueOf(viewTextDeadline.getText()) + " " + String.valueOf(viewTextPriority.getText()) + " " + String.valueOf(viewTextStatus.getText()) + " " + String.valueOf(viewTextSubTask.getText());
                            fileWriter(fileName);
                        } catch (RuntimeException e1) {
                            System.out.println(e1);
                        }
                    }
                }



    );

        deleteAssigneeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    throw new RuntimeException("I do not know how to do this, but I'll soon learn");
                } catch (RuntimeException e1) {
                    System.out.println(e1);
                }
            }
        });

        deleteTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    throw new RuntimeException("I do not know how to do this, but I'll soon learn");
                } catch (RuntimeException e1) {
                    System.out.println(e1);
                }
            }
        });

    }

    public class TaskActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TaskPanel = new JPanel();
            TaskPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            TaskPanel.setSize(new Dimension(700, 700));

            TaskPanel.add(viewTextTName);
            TaskPanel.add(viewTextDescription);
            TaskPanel.add(viewTextDeadline);
            TaskPanel.add(viewTextPriority);
            TaskPanel.add(viewTextStatus);
            TaskPanel.add(viewTextSubTask);
            viewFrame.add(TaskPanel);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        TaskManagerModel model = (TaskManagerModel) o;
        displayModels(model);
    }

    public void updateViewTextConsole(String textConsole) {
        viewTextConsole.setText(textConsole);
        System.out.println(textConsole);
    }


    public void displayModels(TaskManagerModel model){
        for (Assignee assignee: model.getAssignees()){
            updateViewTextConsole(assignee.getName()+" "+
                    assignee.getLastname()+" "+
                    assignee.getPost()
            );

        }
        for (Task task: model.getTasks()){
            updateViewTextConsole(task.getT_name()+" "+
                    task.getDescription()+" "+
                    task.getDeadline()+" "+
                    task.getPriority()+" "+
                    task.getStatus()+" "+
                    task.getSubtask()
            );

        }
    }


    public void fileWriter(String fileName) {
        try {
            FileWriter writer = new FileWriter("text/"+fileName+".txt", true);
            writer.write(fileName);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
