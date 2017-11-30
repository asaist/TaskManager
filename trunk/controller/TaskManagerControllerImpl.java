package controller;

import model.Assignee;
import model.AssigneeImpl;
import model.Task;
import model.TaskImpl;
import model.TaskManagerModel;
import view.TaskManagerView;
import view.TaskManagerViewImpl;

import java.util.List;
import java.util.Objects;

import static model.Assignee.post;


public class TaskManagerControllerImpl implements TaskManagerController {
    TaskManagerModel model;
    TaskManagerView view;
    TaskManagerController controller;

    public TaskManagerControllerImpl (TaskManagerModel model) {
        this.model = model;
        view = new TaskManagerViewImpl(this, model);

    }
    //Task
    public void addTask (String t_name, String description, String deadline,String priority,String status,String subtask){
        Task task = new TaskImpl();
        checkFields(t_name,description, deadline,priority,status,subtask, task);
        model.addTask(task);
        System.out.println(assignee.toString());
    }
    //Assaignee
    public void addAssignee (String name, String lastName, String post){
        Assignee assignee = new AssigneeImpl();
        checkFields(name, lastName, post, assignee);
        model.addAssaignee(assignee);
        System.out.println(assignee.toString());
    }



    public void checkFields (String name, String lastName, String post, Assignee assignee) {

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

}

