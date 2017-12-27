package server.main;


import common.service.TextDao;
import server.controller.TaskManagerController;
import server.controller.TaskManagerControllerImpl;
import server.model.TaskManagerModel;
import server.model.TaskManagerModelImpl;
import server.view.ClientDataViewImpl;
import server.view.TaskManagerView;
import server.view.TaskManagerViewImpl;
import java.io.IOException;


public class TaskManager {
    public static void main (String[]args) throws IOException {
        TextDao txtFileWork = new TextDao();
        TaskManagerModel model = new TaskManagerModelImpl();
        model.addAllTask(txtFileWork.readAll());
        TaskManagerController controller = new TaskManagerControllerImpl(model);
        TaskManagerView view = new TaskManagerViewImpl(controller,model);
        TaskManagerView viewClient = new ClientDataViewImpl(controller,model);
        view.createView();
        viewClient.createView();
        model.addWatcher(view);
        model.addWatcher(viewClient);
    }
}
