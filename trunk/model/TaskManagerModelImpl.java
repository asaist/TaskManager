package model;

import java.util.*;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private List<Task> tasks=new ArrayList();
    private List<Coloring> colorings=new ArrayList();
    private List<Assignee> assignees=new ArrayList();




    public List<Assignee> getAssignees() {
        return assignees;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public void create(){ System.out.println("Запись добавлена."); }

    //Task
    public void addTask (Task task) {
        checkTasks(task);
        tasks.add(task);
        setChanged();
        notifyObservers();
        System.out.println("Запись добавлена  в модель " + task.getT_name());
    }
    private void checkTasks (Task task) {
        for (Task task1:getTasks()) {
            if (task1.equals(task)) {
                throw new RuntimeException("a record already exists");
            }
        }
    }

    //Assaignee
     public void addAssaignee (Assignee assignee) {
         checkAssignees(assignee);
         assignees.add(assignee);
         setChanged();
         notifyObservers();
         System.out.println("Запись добавлена  в модель " + assignee.getName());
    }

    private void checkAssignees (Assignee assignee) {
            for (Assignee assignee1:getAssignees()) {
                    if (assignee1.equals(assignee)) {
                        throw new RuntimeException("a record already exists");
                    }
            }
    }
}
