package model;

public interface Task {
    int id = 0;
    String t_name=null;
    String description=null;
    String deadline=null;
    String priority=null;
    String status=null;
    String subtask=null;

    int setId(int id);

    int getId();

    void setT_name(String t_name);

    String getTaskName();

    void setDescription(String description);

    String getDescription();

    void setDeadline(String deadline);

    String getDeadline();

    void setPriority(String priority);

    String getPriority();
    void setStatus(String status);

    String getStatus();
    void setSubtask(String subtask);

    String getSubtask();
    
}
