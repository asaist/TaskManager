package client.main;


import client.controller.ClientTaskManagerControllerImpl;
import client.model.TXTFileWork;
import client.model.ClientTaskManagerModelImpl;
import client.model.XMLFileWork;
import client.view.ClientTaskManagerViewImpl;
import java.io.IOException;



public class TaskManager {
    public static void main (String[]args) throws IOException {
        ClientTaskManagerModelImpl model = new ClientTaskManagerModelImpl();
        ClientTaskManagerControllerImpl controller = new ClientTaskManagerControllerImpl(model);
        ClientTaskManagerViewImpl view = new ClientTaskManagerViewImpl(controller,model);
//        XMLFileWork xmlFileWork = new XMLFileWork();
//        TXTFileWork txtFileWork = new TXTFileWork(model);
//        txtFileWork.fileReader();
//        xmlFileWork.fileReader();
        view.createView();
        model.addObserver(view);
        //model.addObserver();
    }
}
