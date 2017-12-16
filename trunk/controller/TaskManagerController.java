package controller;

import model.Assignee;
import model.Task;

import java.io.IOException;
import java.util.List;

public interface TaskManagerController {
    void addAssignee (String name, String lastName, String post);
    void addTask (String t_name, String description, String deadline,String priority,String status,String subtask);
    void deleteTask(Task task);
}

