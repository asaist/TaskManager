package common.service;

import common.entity.Task;
import common.entity.TaskImpl;
import server.model.TaskManagerModelImpl;

import java.io.*;

public class TXTFileWork implements FileWork {


    private static final String tasksStorageFileName="tasksStorageFileName.txt";

    TaskManagerModelImpl model;

    public TXTFileWork(TaskManagerModelImpl model) {
        this.model = model;
    }

    public TXTFileWork() {
    }

    public static String getTasksStorageFileName() {
        return tasksStorageFileName;
    }

    @Override
    public void fileWriter(Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tasksStorageFileName, true));
            writer.write(task.toString()+System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fileReader() {

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(tasksStorageFileName));
            String line;
            while ((line = bReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Task task = new TaskImpl();
                    String[] fields = line.split(";");
                    task.setT_name(fields[1]);
                    task.setDescription(fields[2]);
                    task.setDeadlineYear(fields[3]);
                    task.setDeadlineMonth(fields[4]);
                    task.setDeadlineDay(fields[5]);
                    task.setDeadlineHour(fields[6]);
                    task.setPriority(fields[7]);
                    task.setStatus(fields[8]);
                    task.setSubtask(fields[9]);
                    model.getTasks().add(task);
                    System.out.println("Запись добавлена  в модель " + task.getTaskName());
                }
            }
            bReader.close();
        }catch (FileNotFoundException e) {

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(tasksStorageFileName, true));
                System.out.println("Создан файл " + tasksStorageFileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @Override
    public void deleteTask(Task taskToRemove) {
        File fileTxt = new File(txtFileWork.getTasksStorageFileName());
        fileTxt.delete();
        tasks.remove(taskToRemove);


        for(Task task:tasks){
            xmlFileWork.fileWriter(task);
            txtFileWork.fileWriter(task);

        }
        modelIsChanged();
    }*/
}
