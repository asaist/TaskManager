package model;

import java.io.*;

public class TXTFileWork implements FileWork {


    private static final String tasksStorageFileName="textFile/tasksStorageFileName.txt";

    TaskManagerModelImpl model = new TaskManagerModelImpl();

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
    public void fileReader(String fileName) {

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Task task = new TaskImpl();
                    String[] fields = line.split(";");
                    task.setT_name(fields[1]);
                    task.setDescription(fields[2]);
                    task.setDeadline(fields[3]);
                    task.setPriority(fields[4]);
                    task.setStatus(fields[5]);
                    task.setSubtask(fields[6]);
                    model.getTasks().add(task);
                    System.out.println("Запись добавлена  в модель " + task.getTaskName());
                }
            }
            model.modelIsChanged();
            bReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("Создан файл " + fileName);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
