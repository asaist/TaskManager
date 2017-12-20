package client.model;

import java.util.List;

public interface ClientTaskManagerModel {
    void create ();
    void addTask (Task task);
    List<Task> getTasks();
    void addAssaignee (Assignee assignee);
    List<Assignee> getAssignees();
    void deleteTask (Task task);
}
