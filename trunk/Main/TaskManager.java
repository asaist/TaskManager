package Main;

import Controller.TaskManagerControllerImpl;
import Model.Assignee_Impl;
import Model.Assignee_store_Impl;
import View.ConsoleInputImpl;

public class TaskManager {
    public static void main (String[]args) {
        Assignee_Impl model = new Assignee_Impl("name","lastname","post");
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        Assignee_store_Impl assignee_store_ = new Assignee_store_Impl();
        ConsoleInputImpl newInput = new ConsoleInputImpl(controller,model);
        newInput.createView();
        assignee_store_.addObserver(newInput);

    }
}
