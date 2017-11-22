package main;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;
import model.AssigneeStoreImpl;
import view.ConsoleInputImpl;

public class TaskManager {
    public static void main (String[]args) {
        AssigneeImpl model = new AssigneeImpl("name","lastname","post");
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        AssigneeStoreImpl assignee_store_ = new AssigneeStoreImpl();
        ConsoleInputImpl newInput = new ConsoleInputImpl(controller,model);
        newInput.createView();
        assignee_store_.addObserver(newInput);

    }
}
