package server.view;

import server.model.TaskManagerModel;

import java.io.IOException;

public interface TaskManagerView {
    void updateViewTextConsole(String textConsole);
    void displayModels(TaskManagerModel model) throws IOException;
}
