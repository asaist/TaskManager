package view;

import controller.TaskManagerController;
import model.Assignee;
import model.Task;
import model.TaskManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerViewImpl implements TaskManagerView, Observer{

    private  final TaskManagerController controller;
    private  final TaskManagerModel model;

    private  final JPanel assaigneeControlPanel;
    private  final JPanel taskControlPanel;
    private  final JPanel globalPanel;
    private  final JPanel tasksViewPanel;
    private  final TaskPresenter taskPresenter = new TaskPresenter();

//    private   JPanel TaskPanelButton;
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
        tasksViewPanel = new JPanel();
        globalPanel= new JPanel();
        assaigneeControlPanel = new JPanel();
        taskControlPanel = new JPanel();

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

        globalPanel.setLayout(new BoxLayout(globalPanel, BoxLayout.Y_AXIS));
        tasksViewPanel.setLayout(new BoxLayout(tasksViewPanel, BoxLayout.Y_AXIS));

        assaigneeControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        assaigneeControlPanel.setSize(new Dimension(700, 700));

        assaigneeControlPanel.add(viewTextName);
        assaigneeControlPanel.add(viewTextLastName);
        assaigneeControlPanel.add(viewTextPost);
        assaigneeControlPanel.add(viewTextConsole);
        assaigneeControlPanel.add(addAssaigneeButton);
        assaigneeControlPanel.add(deleteAssigneeButton);

        viewTextName.setSize(new Dimension(100, 100));
        viewTextLastName.setSize(new Dimension(100, 100));
        viewTextPost.setSize(new Dimension(100, 100));
        viewTextConsole.setSize(new Dimension(100, 100));
        addAssaigneeButton.setSize(new Dimension(100, 100));
        deleteAssigneeButton.setSize(new Dimension(100, 100));

        taskControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        taskControlPanel.setSize(new Dimension(700, 700));

        taskControlPanel.add(viewTextTName);
        taskControlPanel.add(viewTextDescription);
        taskControlPanel.add(viewTextDeadline);
        taskControlPanel.add(viewTextPriority);
        taskControlPanel.add(viewTextStatus);
        taskControlPanel.add(viewTextSubTask);
        taskControlPanel.add(addTaskButton);
        taskControlPanel.add(deleteTaskButton);

        viewTextTName.setSize(new Dimension(100, 100));
        viewTextDescription.setSize(new Dimension(100, 100));
        viewTextDeadline.setSize(new Dimension(100, 100));
        viewTextPriority.setSize(new Dimension(100, 100));
        viewTextStatus.setSize(new Dimension(100, 100));
        viewTextSubTask.setSize(new Dimension(100, 100));
        addTaskButton.setSize(new Dimension(100, 100));
        deleteTaskButton.setSize(new Dimension(100, 100));

        globalPanel.add(assaigneeControlPanel);
        globalPanel.add(taskControlPanel);
        globalPanel.add(tasksViewPanel);
        viewFrame.add(globalPanel);


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
                            updateViewTextConsole(e1.toString());

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
        displayModels(model);
        displayModels(model);
    }

    public class TaskPresenter {

        public void displayTask(Task task) {
            JTextField taskName = new JTextField(task.getTaskName());
            JTextField description = new JTextField(task.getDescription());
            JTextField deadline = new JTextField(task.getDeadline());
            JTextField priority = new JTextField(task.getPriority());
            JTextField status = new JTextField(task.getStatus());
            JTextField subtask = new JTextField(task.getSubtask());
            JPanel certainTaskPanel = new JPanel();
            JButton removeButton = new JButton("Delete");//toString = имя кнопки /вызывать task.getId
            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        task.getId();
                        throw new RuntimeException("I do not know how to do this, but I'll soon learn");
                    } catch (RuntimeException e1) {
                        System.out.println(e1);
                    }
                }
            });
            certainTaskPanel.add(taskName);
            certainTaskPanel.add(description);
            certainTaskPanel.add(deadline);
            certainTaskPanel.add(priority);
            certainTaskPanel.add(status);
            certainTaskPanel.add(subtask);
            certainTaskPanel.add(removeButton);

            tasksViewPanel.add(certainTaskPanel);


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

        tasksViewPanel.removeAll();
        for (Assignee assignee: model.getAssignees()){
            updateViewTextConsole(assignee.getName()+" "+
                    assignee.getLastname()+" "+
                    assignee.getPost()
            );

        }
        for (Task task: model.getTasks()){
            updateViewTextConsole(task.getTaskName()+" "+
                    task.getDescription()+" "+
                    task.getDeadline()+" "+
                    task.getPriority()+" "+
                    task.getStatus()+" "+
                    task.getSubtask()
            );
            taskPresenter.displayTask(task);
        }

        globalPanel.updateUI();
    }

}
