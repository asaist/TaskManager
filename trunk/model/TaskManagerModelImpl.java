package model;

import java.io.*;
import java.util.*;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private List<Task> tasks=new ArrayList();
    private List<Coloring> colorings=new ArrayList();
    private List<Assignee> assignees=new ArrayList();
    private static final String tasksStorageFileName="tasksStorageFileName.txt";




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
        checkTasks(task);
        tasks.add(task);
        setChanged();
        notifyObservers();
        System.out.println("Запись добавлена  в модель " + task.getTaskName());
        fileWriter(tasksStorageFileName,task);
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
         System.out.println("Запись добавлена в модель " + assignee.getName());
    }

    private void checkAssignees (Assignee assignee) {
            for (Assignee assignee1:getAssignees()) {
                    if (assignee1.equals(assignee)) {
                        throw new RuntimeException("a record already exists");
                    }
            }
    }


    public void fileWriter(String fileName,Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(task.toString()+System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void fileReader (File file) {
            try {
                BufferedReader bReader = new BufferedReader(new FileReader("textAssignee/" + file.getName()));
                while (bReader.readLine() != null) {
                    System.out.println(bReader.readLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



}
