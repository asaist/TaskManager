package client.view;

import client.model.ClientTaskManagerModel;

import java.io.IOException;

public interface ClientTaskManagerView {
    void updateViewTextConsole(String textConsole);
    void displayModels(ClientTaskManagerModel model);
    void createView();

}
