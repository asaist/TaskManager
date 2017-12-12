package controller;

import model.Assignee;
import model.AssigneeImpl;
import model.Task;
import model.TaskImpl;
import model.TaskManagerModel;
import view.TaskManagerView;
import view.TaskManagerViewImpl;

import java.io.*;
import java.util.List;
import java.util.Objects;

import static model.Assignee.post;


public class TaskManagerControllerImpl implements TaskManagerController {
    TaskManagerModel model;
    TaskManagerView view;
    TaskManagerController controller;


    public TaskManagerControllerImpl(TaskManagerModel model) {
        this.model = model;
        view = new TaskManagerViewImpl(this, model);

    }

    //Task
    public void addTask(String t_name, String description, String deadline, String priority, String status, String subtask) {
        Task task = new TaskImpl();
        checkFieldstask(t_name, description, deadline, priority, status, subtask, task);
        if (task.toString() != null) {
            model.addTask(task);

        } else {
            throw new RuntimeException("Введён символ ';'");
        }
    }


    public void checkFieldstask(String t_name, String description, String deadline, String priority, String status, String subtask, Task task) {

        if (isCorrect(t_name)) {
            throw new RuntimeException("t_name is empty");
        } else {
            task.setT_name(t_name.trim());
        }
        if (isCorrect(description)) {
            throw new RuntimeException("description is empty");
        } else {
            task.setDescription(description.trim());
        }
        if (isCorrect(deadline)) {
            throw new RuntimeException("deadline is empty");
        } else {
            task.setDeadline(deadline.trim());
        }
        if (isCorrect(priority)) {
            throw new RuntimeException("priority is empty");
        } else {
            task.setPriority(priority.trim());
        }
        if (isCorrect(status)) {
            throw new RuntimeException("status is empty");
        } else {
            task.setStatus(status.trim());
        }
        if (isCorrect(subtask)) {
            throw new RuntimeException("subtask is empty");
        } else {
            task.setSubtask(subtask.trim());
        }
    }

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
        return field == null || field.isEmpty() || field.trim().isEmpty();
    }

    public void deleteTask(int idTask, List<Task> tasks) throws IOException {
        File myFile = new File("textFile/tasksStorageFileName.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("textFile/tasksStorageFileName.txt", true));
        if (myFile.exists()) {
            myFile.delete();
        for (Task p: tasks) {
            if (p.getId() == idTask) {
                tasks.remove(p);
                    }
            else {
                writer.write(tasks.toString()+System.getProperty("line.separator"));
                writer.flush();
                writer.close();
                }
            }
        }


    }
}

