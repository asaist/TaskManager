package server.view;

import common.entity.*;
import common.service.Parser;
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
    DataInputStream in ;
    DataOutputStream out ;
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

        int port =1234;

        try (ServerSocket ss= new ServerSocket(port)) {

            System.out.println("Waiting for a client...");

            Socket client=ss.accept(); //сокет общения с клиентом
            System.out.println("Got a client :) ... Finally,someone saw me through all the cover");

            /*InputStream sin = client.getInputStream();
            OutputStream sout = client.getOutputStream();

            in=new ObjectInputStream(sin);
            out=new ObjectOutputStream(sout);*/

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream input = new DataInputStream(client.getInputStream());

            while(!client.isClosed()){
                String entry = input.readUTF();

                if(entry.equalsIgnoreCase("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - "+entry + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }

                out.writeUTF("Server reply - "+entry + " - OK");
                System.out.println("Server Wrote message to client." + entry);

                out.flush();

                Parser parser = new Parser();

                model.addTask((Task) parser.parse(entry));

                System.out.println("Client disconnected");
                System.out.println("Closing connections & channels.");
                //String [] entrys = entry.split(";");
                //controller.addTask(entrys[1],entrys[2],entrys[3],entrys[4],entrys[5],entrys[6],entrys[7],entrys[8],entrys[9]);
            }

            input.close();
            client.close();

            in.close();
            out.close();

            client.close();

           /* DataObject.Action action=null;
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

            System.out.println("Closing connections & channels - DONE.");*/



        } catch (Exception e) {e.printStackTrace();
        }

    }
    @Override
    public void update(Observable o, Object arg) {
        TaskManagerModel model = (TaskManagerModel) o;
        displayModels(model);
    }

}
