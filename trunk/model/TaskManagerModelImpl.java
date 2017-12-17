package model;

import javafx.application.Application;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManagerModelImpl extends Observable implements TaskManagerModel {

    private static final String tasksStorageFileName="textFile/tasksStorageFileName.txt";
    private static final String tasksStorageFileNameXml="xmlFile/tasksStorageFileName.xml";
    private List<Task> tasks=new ArrayList();
    private List<Coloring> colorings=new ArrayList();
    private List<Assignee> assignees=new ArrayList();


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
        if (task != null) {
            checkTasks(task);
            tasks.add(task);
            setChanged();
            notifyObservers();
            System.out.println("Запись добавлена  в модель " + task.getTaskName());
            fileWriterTxt(tasksStorageFileName, task);

            ParamLangXML();
            try {
                fileWriterXml(task);
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    private void checkTasks (Task task) {
        for (Task task1 : getTasks()) {
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

    public void fileReader (String fileName) throws IOException {
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
                    tasks.add(task);
                    System.out.println("Запись добавлена  в модель " + task.getTaskName());
                }
            }
            modelIsChanged();
            bReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("Создан файл " + tasksStorageFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriterTxt(String fileName, Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(task.toString()+System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteTask(Task taskToRemove) {
        File file = new File(tasksStorageFileName);
        file.delete();
        tasks.remove(taskToRemove);
        for(Task task:tasks){
            fileWriterTxt(tasksStorageFileName,task);

        }
        modelIsChanged();
    }

    private void modelIsChanged(){
        setChanged();
        notifyObservers();
    }

    public void ParamLangXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try { builder = factory.newDocumentBuilder(); }
        catch (ParserConfigurationException e) { e.printStackTrace(); }
    }

    DocumentBuilder builder;

    public void fileWriterXml(Task taskAdd) throws TransformerException, IOException {

        Document doc = builder.newDocument();
        Element RootElement=doc.createElement("task_" + taskAdd.getId());

        Element NameElementTaskName=doc.createElement("task_name");
        NameElementTaskName.appendChild(doc.createTextNode(taskAdd.getTaskName()));
        RootElement.appendChild(NameElementTaskName);

        Element NameElementDescription=doc.createElement("description");
        NameElementDescription.appendChild(doc.createTextNode(taskAdd.getDescription()));
        RootElement.appendChild(NameElementDescription);

        Element NameElementDeadline=doc.createElement("deadline");
        NameElementDeadline.appendChild(doc.createTextNode(taskAdd.getDeadline()));
        RootElement.appendChild(NameElementDeadline);

        Element NameElementPriority=doc.createElement("priority");
        NameElementPriority.appendChild(doc.createTextNode(taskAdd.getPriority()));
        RootElement.appendChild(NameElementPriority);

        Element NameElementStatus=doc.createElement("status");
        NameElementStatus.appendChild(doc.createTextNode(taskAdd.getStatus()));
        RootElement.appendChild(NameElementStatus);

        Element NameElementSubtasks=doc.createElement("subtasks");
        NameElementSubtasks.appendChild(doc.createTextNode(taskAdd.getSubtask()));
        RootElement.appendChild(NameElementSubtasks);

        doc.appendChild(RootElement);

        Transformer t= TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(tasksStorageFileNameXml)));

    }

}
