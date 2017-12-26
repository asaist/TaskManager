package server.main;


import client.model.Task;
import common.service.TextDao;
import server.controller.TaskManagerControllerImpl;
import common.service.TXTFileWork;
import server.model.TaskManagerModelImpl;
import common.service.XMLFileWork;
import server.view.TaskManagerViewImpl;
import java.io.IOException;
import java.util.List;


public class TaskManager {
    public static void main (String[]args) throws IOException {
        TextDao txtFileWork = new TextDao();
        TaskManagerModelImpl model = new TaskManagerModelImpl();
        model.addAllTask((List<Task>)txtFileWork.readAll());
        TaskManagerControllerImpl controller = new TaskManagerControllerImpl(model);
        TaskManagerViewImpl view = new TaskManagerViewImpl(controller,model);
        view.createView();
        model.addObserver(view);
    }
}
