package view;

import controller.TaskManagerController;
import model.Assignee;
import model.Task;
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

    private  final JPanel addAssaigneePanel;
    private  final JPanel addTaskPanel;
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



    public TaskManagerViewImpl(TaskManagerController controller, TaskManagerModel model) {
        this.controller = controller;
        this.model = model;

        String textViewFrame = "view";
        String addAssaigneeButtonLable = "Add Assaignee";
        String addTaskButtonLable = "Add Task";
        String deleteAssigneeButtonLable = "Delete Assignee";
        String deleteTaskButtonLable = "Delete Task";
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
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contents = new JPanel(new VerticalLayout());

        addAssaigneePanel = new JPanel();
        addAssaigneePanel.setSize(new Dimension(700, 700));
        addTaskPanel = new JPanel();
        addTaskPanel.setSize(new Dimension(700, 700));
        addAssaigneeButton = new JButton(addAssaigneeButtonLable);
        addAssaigneeButton.setSize(new Dimension(100, 100));
        addTaskButton = new JButton(addTaskButtonLable);
        addTaskButton.setSize(new Dimension(100, 100));

        contents.add(addAssaigneePanel);
        contents.add(addTaskPanel);
        viewFrame.setContentPane(contents);

        deleteAssigneeButton = new JButton(deleteAssigneeButtonLable);
        deleteAssigneeButton.setSize(new Dimension(100, 100));
        deleteTaskButton = new JButton(deleteTaskButtonLable);
        deleteTaskButton.setSize(new Dimension(100, 100));


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

    public void createView () {


        addAssaigneePanel.add(viewTextName);
        addAssaigneePanel.add(viewTextLastName);
        addAssaigneePanel.add(viewTextPost);
        addAssaigneePanel.add(viewTextConsole);
        addAssaigneePanel.add(addAssaigneeButton);
        //addAssaigneePanel.add(addTaskButton);
        addAssaigneePanel.add(deleteAssigneeButton);
        viewFrame.add(addAssaigneePanel);

        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addTaskPanel.add(viewTextTName);
        addTaskPanel.add(viewTextDescription);
        addTaskPanel.add(viewTextDeadline);
        addTaskPanel.add(viewTextPriority);
        addTaskPanel.add(viewTextStatus);
        addTaskPanel.add(viewTextSubTask);
        addTaskPanel.add(addTaskButton);
        addTaskPanel.add(deleteTaskButton);

        viewFrame.add(addTaskPanel);

        viewFrame.pack();
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addAssaigneeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.addAssignee(String.valueOf(viewTextName.getText()), String.valueOf(viewTextLastName.getText()), String.valueOf(viewTextPost.getText()));
            } catch (RuntimeException e1) {
                System.out.println(e1);
            }
        }
    });
                addTaskButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            controller.addTask(String.valueOf(viewTextTName.getText()),String.valueOf(viewTextDescription.getText()), String.valueOf(viewTextDeadline.getText()),String.valueOf(viewTextPriority.getText()), String.valueOf(viewTextStatus.getText()), String.valueOf(viewTextSubTask.getText()));
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


}
