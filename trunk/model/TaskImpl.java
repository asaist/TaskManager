package model;

public class TaskImpl implements Task {
    private String t_name;
    private String description;
    private String deadline;
    private String priority;
    private String status;
    private String subtask;


    TaskImpl(String t_name, String description, String deadline, String priority, String status, String subtask){
        this.t_name=t_name;
        this.description=description;
        this.deadline=deadline;
        this.priority=priority;
        this.status=status;
        this.subtask=subtask;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }



    @Override
    public boolean equals(Object anObject){
        if (anObject instanceof TaskImpl) {
            TaskImpl task = (TaskImpl) anObject;
                /*if (name == null || assignee.getName() == null)  {
                    return false;
                }*/

            if (!t_name.equals(task.getT_name())) {
                return false;
            }
            if (!description.equals(task.getDescription())) {
                return false;
            }
            if (!deadline.equals(task.getDeadline())) {
                return false;
            }
            if (!priority.equals(task.getPriority())) {
                return false;
            }
            if (!status.equals(task.getStatus())) {
                return false;
            }
            if (!subtask.equals(task.getSubtask())) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString(){
        return (t_name+" "+description+" "+deadline+" "+priority+" "+status+" "+subtask);
    }



}
