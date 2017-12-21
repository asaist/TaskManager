package server.model;


import common.entity.Assignee;
import common.entity.Coloring;
import common.entity.Entity;
import common.entity.Task;
import common.service.TXTFileWork;
import common.service.TextDao;
import common.service.XMLFileWork;

import java.io.*;
import java.util.*;


public class TaskManagerModelImpl extends Observable implements TaskManagerModel {





    private List<Task> tasks=new ArrayList();
    private List<Coloring> colorings=new ArrayList();
    private List<Assignee> assignees=new ArrayList();
    XMLFileWork xmlFileWork = new XMLFileWork();
    TXTFileWork txtFileWork = new TXTFileWork();


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
        //int j=0;
        //task.setId(j);
        if (task != null) {
            checkTasks(task);
            tasks.add(task);
            setChanged();
            notifyObservers();
            System.out.println("Запись добавлена  в модель " + task.getTaskName());
            TextDao txtFileWork = new TextDao() ;
            txtFileWork.create((Entity) task);
        }
        }

    private void checkTasks (Task task) {
        for (Task task1 : getTasks()) {
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
         System.out.println("Запись добавлена в модель " + assignee.getName());
    }

    private void checkAssignees (Assignee assignee) {
            for (Assignee assignee1:getAssignees()) {
                    if (assignee1.equals(assignee)) {
                        throw new RuntimeException("a record already exists");
                    }
            }
    }



    @Override
    public void deleteTask(Task taskToRemove) {
        File fileTxt = new File(txtFileWork.getTasksStorageFileName());
        fileTxt.delete();
        tasks.remove(taskToRemove);


        for(Task task:tasks){
            xmlFileWork.fileWriter(task);
            txtFileWork.fileWriter(task);

        }
        modelIsChanged();
    }

    void modelIsChanged(){
        setChanged();
        notifyObservers();
    }


}
