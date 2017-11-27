package controller;

import model.Assignee;
import model.AssigneeImpl;
import model.TaskManagerModel;
import model.TaskManagerModelImpl;
import view.TaskManagerViewImpl;
import java.util.List;
import java.util.Objects;


public class TaskManagerControllerImpl implements TaskManagerController {
    TaskManagerModelImpl model;
    TaskManagerViewImpl view;
    TaskManagerControllerImpl controller;

    public TaskManagerControllerImpl (TaskManagerModelImpl model) {
        this.model = model;
        view = new TaskManagerViewImpl(this, model);

    }

    public void addAssignee (String name, String lastName, String post){
        AssigneeImpl assignee = new AssigneeImpl();
        checkFields(name, lastName, post, assignee);
        checkAssignees(assignee);
    }

    public void checkAssignees (AssigneeImpl assignee) {
        if (model.getAssigneesimpl().size() == 0) {
            model.addAssaignee(assignee);
        } else {
            for (int i = 0; i < model.getAssigneesimpl().size(); i++) {
                try {
                    if (model.getAssigneesimpl().get(i) == assignee) {
                        throw new RuntimeException("a record already exists");
                    } else {
                        model.addAssaignee(assignee);
                    }
                } catch (RuntimeException e) {
                    view.updateViewTextConsole("Error " + e);
                    System.out.println(view.displayText());
                }
            }
        }
    }

    public void checkFields (String name, String lastName, String post, AssigneeImpl assignee) {

        try {

            if (name == null || name == "" || name == " ") {
                throw new RuntimeException("name is empty");
            } else {
                assignee.setName(name);
            }

            if (lastName == null || lastName == "" || lastName == " ") {
                throw new RuntimeException("lastName is empty");
            } else {
                assignee.setLastname(lastName);
            }

            if (post == null || post == "" || post == " ") {
                throw new RuntimeException("post is empty");
            } else {
                assignee.setPost(post);
            }
        }
            catch (RuntimeException e) {
                System.out.println(name);
                view.updateViewTextConsole("Error "+e);
                System.out.println(view.displayText());
        }

    }

}

