package Controller;

import Model.Assignee_Impl;
import View.ConsoleInputImpl;


public class TaskManagerControllerImpl implements TaskManagerController {
    Assignee_Impl model;
    ConsoleInputImpl view;

    public TaskManagerControllerImpl (Assignee_Impl model) {
        this.model = model;
        view = new ConsoleInputImpl(this, model);

    }

    public void assigneeImplSetName(String name) {
        model.setName(name);
        System.out.println(model.getName());
    }


    }

