package model;

import java.util.List;

public interface TaskManagerModel {
    void create ();
    void addAssaignee (Assignee assignee);
    List<Assignee> getAssignees();
}
