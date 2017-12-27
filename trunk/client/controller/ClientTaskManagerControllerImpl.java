package client.controller;

import client.model.Assignee;
import client.model.AssigneeImpl;
import client.model.Task;
import client.model.TaskImpl;
import client.model.ClientTaskManagerModel;
import client.view.ClientTaskManagerView;
import client.view.ClientTaskManagerViewImpl;

import java.io.*;
import java.util.List;
import java.util.Objects;

import static client.model.Assignee.post;


public class ClientTaskManagerControllerImpl implements ClientTaskManagerController {
    ClientTaskManagerModel model;
    ClientTaskManagerView view;
    ClientTaskManagerController controller;


    public ClientTaskManagerControllerImpl(ClientTaskManagerModel model) {
        this.model = model;
        view = new ClientTaskManagerViewImpl(this, model);

    }

    //Task
    public void addTask(String t_name, String description, String deadline, String priority, String status, String subtask) {
        Task task = new TaskImpl();
        checkFieldstask(t_name, description, deadline, priority, status, subtask, task);
        model.addTask(task);
        }



    public void checkFieldstask(String t_name, String description, String deadline, String priority, String status, String subtask, Task task) {


            if (isCorrect(t_name)) {
                throw new RuntimeException("t_name is not correct");
            } else {

                task.setT_name(t_name.trim());
            }
            if (isCorrect(description)) {
                throw new RuntimeException("description is not correct");
            } else {
                task.setDescription(description.trim());
            }
            if (isCorrect(deadline)) {
                throw new RuntimeException("deadline is not correct");
            } else {
                task.setDeadline(deadline.trim());
            }
            if (isCorrect(priority)) {
                throw new RuntimeException("priority is not correct");
            } else {
                task.setPriority(priority.trim());
            }
            if (isCorrect(status)) {
                throw new RuntimeException("status is not correct");
            } else {
                task.setStatus(status.trim());
            }
            if (isCorrect(subtask)) {
                throw new RuntimeException("subtask is not correct");
            } else {
                task.setSubtask(subtask.trim());
            }
        }

   // }

    //Assaignee
    public void addAssignee(String name, String lastName, String post) {
        Assignee assignee = new AssigneeImpl();
        checkFields(name, lastName, post, assignee);
        model.addAssaignee(assignee);
        System.out.println(assignee.toString());
    }


    public void checkFields(String name, String lastName, String post, Assignee assignee) {

        if (isCorrect(name)) {
            throw new RuntimeException("name is empty");
        } else {
            assignee.setName(name.trim());
        }

        if (isCorrect(lastName)) {
            throw new RuntimeException("lastName is empty");
        } else {
            assignee.setLastname(lastName.trim());
        }

        if (isCorrect(post)) {
            throw new RuntimeException("post is empty");
        } else {
            assignee.setPost(post.trim());
        }
    }

    private boolean isCorrect(String field) {
        return field == null || field.isEmpty() || field.trim().isEmpty() || field.indexOf(";" ) != -1;
    }

    public void deleteTask(Task task) {
        model.deleteTask(task);
    }
}
