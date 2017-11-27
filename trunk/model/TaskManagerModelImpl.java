package model;

import java.util.*;

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

     public void addAssaignee (AssigneeImpl assignee) {

        try {
                if (assigneesimpl.size()==0) {
                    assigneesimpl.add(assignee);
                    setChanged();
                    notifyObservers();
                } else{
                    for (int i=0;i<assigneesimpl.size();i++){
                        if (assignee==assigneesimpl.get(i)){
                            
                        }

                    }
                }

        }
        catch (RuntimeException e) {

            System.out.println("123");
        }
    }




}
