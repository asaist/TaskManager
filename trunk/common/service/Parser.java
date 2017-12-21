package common.service;

import common.entity.Entity;
import common.entity.Task;
import common.entity.TaskImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {


    public Entity parse(String line) throws IOException {


        Task task = new TaskImpl();
        String[] fields = line.split(";");
        if ((fields.length == 7)) {
            task.setId(Integer.parseInt(fields[0]));
            task.setT_name(fields[1]);
            task.setDescription(fields[2]);
            task.setDeadline(fields[3]);
            task.setPriority(fields[4]);
            task.setStatus(fields[5]);
            task.setSubtask(fields[6]);
        }
        return (Entity) task;
    }
}




