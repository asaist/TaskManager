package model;

import java.util.List;

public interface TaskManagerModel {
    void create ();
    void addTask (Task task);
    List<Task> getTasks();
    void addAssaignee (Assignee assignee);
    List<Assignee> getAssignees();
    void deleteTask (Task task);
}
