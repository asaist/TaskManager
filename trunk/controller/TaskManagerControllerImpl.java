package controller;

import model.AssigneeImpl;
import model.TaskManagerModel;
import model.TaskManagerModelImpl;
import view.TaskManagerViewImpl;

import java.util.List;
import java.util.Objects;


public class TaskManagerControllerImpl implements TaskManagerController {
    TaskManagerModelImpl model;
    TaskManagerViewImpl view;

    public TaskManagerControllerImpl (TaskManagerModelImpl model) {
        this.model = model;
        view = new TaskManagerViewImpl(this, model);

    }

    public void checkFields (String name, String lastName, String post) {

        AssigneeImpl assignee = new AssigneeImpl(name, lastName, post);

        try {
            if (name == null || Objects.equals(name, "") || Objects.equals(name, " ")) {
                throw new RuntimeException("name is empty");
            } else {
                assignee.setName(name);
            }

            if (lastName == null || Objects.equals(lastName, "") || Objects.equals(lastName, " ")) {
                throw new RuntimeException("lastName is empty");
            } else {
                assignee.setLastname(lastName);
            }

            if (post == null || Objects.equals(post, "") || Objects.equals(post, " ")) {
                throw new RuntimeException("post is empty");
            } else {
                assignee.setPost(post);
            }

            model.addAssaignee(assignee);

        }

            catch (RuntimeException e) {
                view.updateViewTextConsole("Error "+e);
                System.out.println(view.displayText());
        }


    }

}

