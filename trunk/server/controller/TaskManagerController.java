package server.controller;

import common.entity.Task;

import java.io.IOException;

public interface TaskManagerController {
    void addAssignee (String name, String lastName, String post);
    void addTask (String t_name, String description, String deadlineYear, String deadlineMonth, String deadlineDay, String deadlineHour, String priority, String status, String subtask);
    void deleteTask(Task task) throws IOException;
}

