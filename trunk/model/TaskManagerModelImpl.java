package model;

import java.util.*;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private List<Task> tasks=new ArrayList();
    private List<Coloring> colorings=new ArrayList();
    private List<Assignee> assignees=new ArrayList();


    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }



     public void create(){
        System.out.println("Запись добавлена.");
    }
     public void addTask(String t_name,String description,String deadline,String priority,String status,String subtask){
         tasks.add(new TaskImpl(t_name, description, deadline, priority, status, subtask));
         notifyObservers();
     }
     public void addColoring(String color){
         colorings.add(new ColoringImpl(color));
     }

     public void addAssaignee (Assignee assignee) {
         checkAssignees(assignee);
         assignees.add(assignee);
         setChanged();
         notifyObservers();
         System.out.println("Запись добавлена  в модель " + assignee.getName());
    }

    private void checkAssignees (Assignee assignee) {
        System.out.println(getAssignees().size());

            for (Assignee assignee1:getAssignees()) {
                    if (assignee1.equals(assignee)) {
                        throw new RuntimeException("a record already exists");
                    }
            }
    }
}
