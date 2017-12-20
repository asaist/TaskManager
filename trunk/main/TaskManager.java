package main;


import controller.TaskManagerControllerImpl;
import model.TXTFileWork;
import model.TaskManagerModelImpl;
import model.XMLFileWork;
import view.TaskManagerViewImpl;
import java.io.IOException;



public class TaskManager {
    public static void main (String[]args) throws IOException {
        TaskManagerModelImpl model = new TaskManagerModelImpl();
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        XMLFileWork xmlFileWork = new XMLFileWork();
        TXTFileWork txtFileWork = new TXTFileWork(model);
        txtFileWork.fileReader();
        view.createView();
        model.addObserver(view);
        //model.addObserver();
    }
}
