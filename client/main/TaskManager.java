package client.main;


import client.controller.ClientTaskManagerControllerImpl;
import client.model.ClientTaskManagerModelImpl;
import client.view.ClientTaskManagerViewImpl;


public class TaskManager {
    public static void main (String[]args){
        ClientTaskManagerModelImpl model = new ClientTaskManagerModelImpl();
        ClientTaskManagerControllerImpl controller = new ClientTaskManagerControllerImpl(model);
        ClientTaskManagerViewImpl view = new ClientTaskManagerViewImpl(controller,model);



        view.createView();
        model.addObserver(view);
        //model.addObserver();
    }
}
