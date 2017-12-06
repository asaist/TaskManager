package main;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;
import model.TaskManagerModelImpl;
import view.TaskManagerViewImpl;

public class TaskManager {
    public static void main (String[]args) {
        TaskManagerModelImpl model = new TaskManagerModelImpl();

        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        view.createView();
        model.addObserver(view);
    }
}
