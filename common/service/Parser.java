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
        Entity entity = new Entity() {
            @Override
            public boolean equals(Object anObject) {
                return false;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public Integer getId() {
                return null;
            }
        };
        String[] fields = line.split(";");
        if ((fields.length == 7)) {
            task.setT_name(fields[1]);
            task.setDescription(fields[2]);
            task.setDeadline(fields[3]);
            task.setPriority(fields[4]);
            task.setStatus(fields[5]);
            task.setSubtask(fields[6]);
            System.out.println("Запись добавлена  в модель " + task.getTaskName());
        }
        return (Entity) task;
    }
}




