package controller;

import model.Assignee;

public interface TaskManagerController {
    void addAssignee (String name, String lastName, String post);
    void addTask (String t_name, String description, String deadline,String priority,String status,String subtask);

}

