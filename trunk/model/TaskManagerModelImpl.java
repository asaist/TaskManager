package model;

import java.util.*;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private List<Observer> assaignees = new ArrayList();
    private List<Observer> tasks = new ArrayList();
    private List<TaskImpl> tasksimpl=new ArrayList();
    private List<ColoringImpl> coloringsimpl=new ArrayList();

    public List<AssigneeImpl> getAssigneesimpl() {
        return assigneesimpl;
    }

    public void setAssigneesimpl(List<AssigneeImpl> assigneesimpl) {
        this.assigneesimpl = assigneesimpl;
    }

    private List<AssigneeImpl> assigneesimpl=new ArrayList();
    private List<Observer> colorings = new ArrayList();

     public void create(){
        System.out.println("Запись добавлена.");
    }
     public void addTask(String t_name,String description,String deadline,String priority,String status,String subtask){
         tasksimpl.add(new TaskImpl(t_name, description, deadline, priority, status, subtask));
         notifyObservers();
     }
     public void addColoring(String color){
         coloringsimpl.add(new ColoringImpl(color));
     }

     public void addAssaignee (AssigneeImpl assignee) {
         assigneesimpl.add(assignee);
         setChanged();
         notifyObservers();
         System.out.println("Запись добавлена  в модель " + assignee.getName());
    }




}
