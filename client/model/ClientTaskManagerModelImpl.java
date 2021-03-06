package client.model;


import client.view.ClientTaskManagerView;
import common.entity.Assignee;
import common.entity.Coloring;
import common.entity.Entity;
import common.entity.Task;
import common.service.GenericDao;

import java.util.*;


public class ClientTaskManagerModelImpl extends Observable implements ClientTaskManagerModel {


    private List<Task> tasks = new ArrayList();
    private List<Coloring> colorings = new ArrayList();
    private List<Assignee> assignees = new ArrayList();
    private final ServerDataViewImpl dao;

    public ClientTaskManagerModelImpl(ServerDataViewImpl dao) {
        this.dao = dao;
    }


    public List<Assignee> getAssignees() {
        return assignees;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public void create() {
        System.out.println("Запись добавлена.");
    }

    //Task
    public void addTask(Task task) {
        //int j=0;
        //task.setId(j);
        if (task != null) {
            checkTasks(task);
            tasks.add(task);
            dao.create((Entity) task);
            System.out.println("Запись добавлена  в модель " + task.getTaskName());
            setChanged();
            notifyObservers();
        }
    }

    public void addAllTask(List<Entity> entities1) {

        if (entities1 == null) {
            System.out.println("Задач пока нет");

        } else {

            for (Entity entity : entities1) {
                if (entity != null) {
                    checkTasks((Task) entity);
                    tasks.add((Task) entity);
                    setChanged();
                    notifyObservers();
                }
            }
        }
    }

    @Override
    public void addWatcher(ClientTaskManagerView view) {
        addObserver(view);
    }


    private void checkTasks(Task task) {
        for (Task task1 : getTasks()) {
            if (task1.equals(task)) {
                throw new RuntimeException("a record already exists");
            }
        }
    }

    //Assaignee
    public void addAssaignee(Assignee assignee) {
        checkAssignees(assignee);
        assignees.add(assignee);
        setChanged();
        notifyObservers();
        System.out.println("Запись добавлена в модель " + assignee.getName());
    }

    private void checkAssignees(Assignee assignee) {
        for (Assignee assignee1 : getAssignees()) {
            if (assignee1.equals(assignee)) {
                throw new RuntimeException("a record already exists");
            }
        }
    }

    @Override
    public void deleteTask(Task taskToRemove) {
        dao.delete((Entity) taskToRemove);
        tasks.remove(taskToRemove);
        modelIsChanged();
    }

    public void updateTask(Task taskToUpdate) {
        dao.update((Entity) taskToUpdate);
        tasks.remove(searchTask(taskToUpdate));
        tasks.add(taskToUpdate);
        modelIsChanged();
    }


    public void modelIsChanged() {
        setChanged();
        notifyObservers();
    }


    public Task searchTask(Task task) {
        Task foundTask = null;
        for (Task task1 : tasks) {
            if (task1.getId().equals(task.getId())) {
                foundTask = task1;
            }
        }
        return foundTask;
    }

}
