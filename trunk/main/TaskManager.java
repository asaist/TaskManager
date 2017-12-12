package main;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;
import model.TaskManagerModelImpl;
import view.TaskManagerViewImpl;

import java.io.File;

public class TaskManager {
    public static void main (String[]args) {
        TaskManagerModelImpl model = new TaskManagerModelImpl();
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        //model.fileReader("textFile/tasksStorageFileName.txt");
        view.createView();
        model.addObserver(view);
    }
}
