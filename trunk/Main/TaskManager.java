package Main;

import Controller.TaskManagerControllerImpl;
import Model.Assignee_Impl;
import View.ConsoleInputImpl;

public class TaskManager {
    public static void main (String[]args) {

        ConsoleInputImpl newInput = new ConsoleInputImpl();
        newInput.createView();
    }
}
