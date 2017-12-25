package server.main;


import client.model.Task;
import common.service.TextDao;
import server.controller.TaskManagerControllerImpl;
import common.service.TXTFileWork;
import server.model.TaskManagerModelImpl;
import common.service.XMLFileWork;
import server.view.TaskManagerViewImpl;
import java.io.IOException;



public class TaskManager {
    public static void main (String[]args) throws IOException {
        TaskManagerModelImpl model = new TaskManagerModelImpl();
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        TextDao txtFileWork = new TextDao();
        view.createView();
        model.addObserver(view);
    }
}