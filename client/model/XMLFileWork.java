package client.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLFileWork implements FileWork {
    public static String getTasksStorageFileNameXml() {
        return tasksStorageFileNameXml;
    }

    private static final String tasksStorageFileNameXml="server/xmlFile/tasksStorageFileName.xml";

    DocumentBuilder builder;

    @Override
    public void fileWriter(Task taskAdd) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try { builder = factory.newDocumentBuilder(); }
        catch (ParserConfigurationException e) { e.printStackTrace(); }

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

        Transformer t = null;
        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        try {
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(tasksStorageFileNameXml)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void fileReader() {
        try {

            final File xmlFile = new File(System.getProperty("user.dir")
                    + File.separator + tasksStorageFileNameXml);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: "
                    + doc.getDocumentElement().getNodeName());


            NodeList nodeList = doc.getElementsByTagName("task_1");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println();
                System.out.println("Текущий элемент: " + node.getNodeName());
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    System.out.println("Имя: " + element
                            .getElementsByTagName("task_name").item(0)
                            .getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {
            Logger.getLogger(XMLFileWork.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}


