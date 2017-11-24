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
     public void addAssaignee(String name, String lastname, String post){
         assigneesimpl.add(new AssigneeImpl(name, lastname, post));
     }


    public void modelcheckFields (String name, String lastName, String post) {

        AssigneeImpl assignee = new AssigneeImpl(name, lastName, post);

        try {

            for ( int i =0;i<assigneesimpl.size();i++) {
                if (assignee==assigneesimpl.get(i)) {
                    throw new RuntimeException("It already has that assaignee");
                } else {
                    assigneesimpl.add(assignee);
                    notifyObservers();
                }
            }
        }
        catch (RuntimeException e) {

            System.out.println("123");
        }
    }





     public void outputAssigneesImpl () {
         for (int x = 0; x < assigneesimpl.size(); x++){
             System.out.println(assigneesimpl.get(x));
         }
    }


}
