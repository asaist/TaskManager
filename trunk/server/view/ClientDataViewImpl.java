package server.view;

import common.entity.*;
import server.controller.TaskManagerController;
import server.controller.TaskManagerControllerImpl;
import server.model.TaskManagerModel;
import server.model.TaskManagerModelImpl;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.Observable;

import static common.entity.DataObject.Action.DELETE;


public class ClientDataViewImpl implements TaskManagerView {
    boolean flag = false;
    ObjectInputStream in ;
    ObjectOutputStream out ;
    TaskManagerController controller;
    TaskManagerModel model;


    public ClientDataViewImpl(TaskManagerController controller, TaskManagerModel model) {
        this.controller=controller;
        this.model=model;

    }

    @Override
    public void updateViewTextConsole(String textConsole) {

    }

    @Override
    public void displayModels(TaskManagerModel model) {
        try {
            out.write(Integer.valueOf(1) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createView() {

        int port =9999;

        try (ServerSocket ss= new ServerSocket(port)) {

            System.out.println("Waiting for a client...");

            Socket client=ss.accept(); //сокет общения с клиентом
            System.out.println("Got a client :) ... Finally,someone saw me through all the cover");

            InputStream sin = client.getInputStream();
            OutputStream sout = client.getOutputStream();

            in=new ObjectInputStream(sin);
            out=new ObjectOutputStream(sout);


            DataObject.Action action=null;
            Object entity;

            while (!client.isClosed()) {
                //DataObject полностью
                DataObject dto = new DataObjectImpl(in);//заменить на чтение из потока когда найдем

                action = dto.getAction();
                entity= dto.getEntity();
                switch(action){
                    case DELETE:controller.deleteTask((Task)entity);
                    break;
                    case CREATE:
                        if (entity instanceof Task){
                            Task task = (Task)entity;
                            controller.addTask(task.getTaskName(),task.getDescription(),task.getDeadlineYear(),task.getDeadlineMonth(),task.getDeadlineDay(),task.getDeadlineHour(),task.getPriority(),task.getStatus(),task.getSubtask());

                        }else if (entity instanceof Assignee){
                            Assignee assignee=(Assignee) entity;
                            controller.addAssignee(assignee.getName(),assignee.getLastname(),assignee.getLastname());
                        }
                        break;
                    case UPDATE:
                        Task task = (Task)entity;
                        controller.updateTask(task);
                }

                System.out.println("The dumb client just sent me this action: " + action);
                System.out.println("I'm sendng it back...");

                if(dto.equals("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeObject("Server reply - "+ dto + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }

                out.writeObject("Server reply - "+ dto + " - OK");
                System.out.println("Server Wrote message to client.");
                out.flush();
            }
            // если условие выхода - верно выключаем соединения
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            // закрываем сначала каналы сокета !
            in.close();
            out.close();

            // потом закрываем сам сокет общения на стороне сервера!
            client.close();

            // потом закрываем сокет сервера который создаёт сокеты общения
            // хотя при многопоточном применении его закрывать не нужно
            // для возможности поставить этот серверный сокет обратно в ожидание нового подключения

            System.out.println("Closing connections & channels - DONE.");



        } catch (Exception e) {e.printStackTrace();
        }

    }
    @Override
    public void update(Observable o, Object arg) {
        TaskManagerModel model = (TaskManagerModel) o;
        displayModels(model);
    }

}
