package common.service;

import common.entity.Entity;
import common.entity.Task;
import common.entity.TaskImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public void checkFileExistanse () throws IOException {
        File file = new File(TextDao.getFileLocation());
        if(!file.exists()){
            file.createNewFile();

        }
    }




    public List<Entity> parse(Integer id) throws IOException {

        checkFileExistanse();

        BufferedReader bReader = new BufferedReader(new FileReader(TextDao.getFileLocation()));
        Task task = new TaskImpl();
        String line;
        List<Entity> entitys = new ArrayList();
        while ((line = bReader.readLine()) != null) {
            if (!line.isEmpty()) {

                String[] fields = line.split(";");
                if ((fields.length == 7) && (fields[0].equals(id.toString()))) {

                    task.setT_name(fields[1]);
                    task.setDescription(fields[2]);
                    task.setDeadline(fields[3]);
                    task.setPriority(fields[4]);
                    task.setStatus(fields[5]);
                    task.setSubtask(fields[6]);
                    System.out.println("Запись добавлена  в модель " + task.getTaskName());
                }
            }
            entitys.add((Entity) task);

        }
        return entitys;


    }

}


