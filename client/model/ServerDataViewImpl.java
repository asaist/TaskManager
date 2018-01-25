package client.model;

import client.view.ClientTaskManagerView;
import common.entity.Entity;
import common.service.GenericDao;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.Observable;

public class ServerDataViewImpl implements GenericDao {
    ObjectInputStream in ;
    ObjectOutputStream out ;
    Entity response;


    public ServerDataViewImpl() {
        int serverPort = 9999; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.
        // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);


            while (true) {
                //line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
               // System.out.println("Sending this line to the server...");
               // out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                //line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                //System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }



    @Override
    public Integer create(Entity newInstance) {
        try {
            out.writeObject(newInstance);//
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(response==null){
            try {
                response= (Entity)in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return response.getId();
    }

    @Override
    public Entity read(Integer id) {
        return null;
    }

    @Override
    public void update(Entity transientObject) {

    }

    @Override
    public void delete(Entity persistentObject) {

    }

    @Override
    public List<Entity> readAll() {
        try {
            out.writeUTF("getList<Entity>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Entity> response1= (List<Entity>)response;
        while (response1==null){
                try {
                    response1= (List<Entity>)in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }
        return response1;

    }

    @Override
    public void checkFile() {

    }
}
