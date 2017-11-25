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
        AssigneeImpl assignee = new AssigneeImpl(name, lastName , post);
        controller.checkFields(assignee);
        model.addAssaignee(assignee);

    }
    @Override

    public boolean equals(String variableFirst, String variableSecond){
        if (variableFirst == variableSecond) {
            return true;
        }

        else {
            return false;
        }

    }

    public void checkFields (Assignee assignee) {

        String name = assignee.getName();
        String lastName = assignee.getLastname();
        String post = assignee.getPost();



        try {

            if (name == null || controller.equals(name, "") || controller.equals(name, " ")) {
                throw new RuntimeException("name is empty");
            } else {
                assignee.setName(name);
            }

            if (lastName == null || controller.equals(lastName, "") || controller.equals(lastName, " ")) {
                throw new RuntimeException("lastName is empty");
            } else {
                assignee.setLastname(lastName);
            }

            if (post == null || controller.equals(post, "") || controller.equals(post, " ")) {
                throw new RuntimeException("post is empty");
            } else {
                assignee.setPost(post);
            }


        }
            catch (RuntimeException e) {
                view.updateViewTextConsole("Error "+e);
                System.out.println(view.displayText());
        }


    }

}

