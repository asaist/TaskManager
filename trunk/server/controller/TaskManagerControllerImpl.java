package server.controller;

import common.entity.Assignee;
import common.entity.AssigneeImpl;
import common.entity.Task;
import common.entity.TaskImpl;
import server.model.TaskManagerModel;
import server.view.TaskManagerView;
import server.view.TaskManagerViewImpl;


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

