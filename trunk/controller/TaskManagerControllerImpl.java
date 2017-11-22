package controller;

import model.AssigneeImpl;
import view.TaskManagerViewImpl;


public class TaskManagerControllerImpl implements TaskManagerController {
    AssigneeImpl model;
    TaskManagerViewImpl view;

    public TaskManagerControllerImpl (AssigneeImpl model) {
        this.model = model;
        view = new TaskManagerViewImpl(this, model);

    }

    public void assigneeImplSetName(String name) {
        model.setName(name);
        System.out.println(model.getName());
    }


    }

