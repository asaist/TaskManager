package main;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;
import model.TaskManagerModelImpl;
import view.TaskManagerViewImpl;

public class TaskManager {
    public static void main (String[]args) {
        AssigneeImpl model = new AssigneeImpl("name","lastname","post");
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerModelImpl assignee_store_ = new TaskManagerModelImpl();
        TaskManagerViewImpl newInput = new TaskManagerViewImpl(controller,model);
        newInput.createView();
        assignee_store_.addObserver(newInput);

    }
}
