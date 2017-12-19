package main;

import controller.TaskManagerControllerImpl;
import model.AssigneeImpl;
import model.TXTFileWork;
import model.TaskManagerModelImpl;
import model.XMLFileWork;
import view.TaskManagerViewImpl;

import java.io.File;
import java.io.IOException;

public class TaskManager {
    public static void main (String[]args) throws IOException {
        XMLFileWork xmlFileWork = new XMLFileWork();
        TXTFileWork txtFileWork = new TXTFileWork();
        TaskManagerModelImpl model = new TaskManagerModelImpl();
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        txtFileWork.fileReader(txtFileWork.getTasksStorageFileName());
        view.createView();
        model.addObserver(view);
    }
}
