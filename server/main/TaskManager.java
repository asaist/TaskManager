package server.main;


import client.model.Task;
import common.service.TextDao;
import server.controller.TaskManagerController;
import server.controller.TaskManagerControllerImpl;
import server.model.TaskManagerModel;
import server.model.TaskManagerModelImpl;
//import server.view.ClientDataViewImpl;
import server.view.TaskManagerView;
import server.view.TaskManagerViewImpl;
import java.io.IOException;
import java.util.List;


public class TaskManager {
    public static void main (String[]args) throws IOException {
        TextDao txtFileWork = new TextDao();
        TaskManagerModel model = new TaskManagerModelImpl();
        TaskManagerController controller = new TaskManagerControllerImpl(model);
        model.addAllTask(controller.isCorrectDate(txtFileWork.readAll()));
        TaskManagerView view = new TaskManagerViewImpl(controller,model);
        //TaskManagerView viewClient = new ClientDataViewImpl(controller,model);
        view.createView();
        //viewClient.createView();
        model.addWatcher(view);
       // model.addWatcher(viewClient);
    }
}
