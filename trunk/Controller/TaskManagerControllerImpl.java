package controller;

import model.AssigneeImpl;
import view.ConsoleInputImpl;


public class TaskManagerControllerImpl implements TaskManagerController {
    AssigneeImpl model;
    ConsoleInputImpl view;

    public TaskManagerControllerImpl (AssigneeImpl model) {
        this.model = model;
        view = new ConsoleInputImpl(this, model);

    }

    public void assigneeImplSetName(String name) {
        model.setName(name);
        System.out.println(model.getName());
    }


    }

