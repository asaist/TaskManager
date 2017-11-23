package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private List<Observer> assaignees = new ArrayList();
    private List<Observer> tasks = new ArrayList();
    private List<TaskImpl> tasksimpl=new ArrayList();
    private List<ColoringImpl> coloringsimpl=new ArrayList();
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
     public void addAssaignee(String name, String lastname, String post){
         assigneesimpl.add(new AssigneeImpl(name, lastname, post));
     }
}
