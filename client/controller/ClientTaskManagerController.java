package client.controller;

import client.model.Assignee;
import client.model.Task;

import java.io.IOException;
import java.util.List;

public interface ClientTaskManagerController {
    void addAssignee (String name, String lastName, String post);
    void addTask (String t_name, String description, String deadline,String priority,String status,String subtask);
    void deleteTask(Task task);
}

