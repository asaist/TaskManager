package common.service;

import common.entity.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextDao implements GenericDao {

    //private static final String dirName = "server/textFile/";
    private static final String fileName = "textFile.txt";


    public static String getFileLocation() {
        return /*dirName + */fileName;
    }

    @Override
    public Integer create(Entity entity) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFileLocation(), true));
            writer.write(entity.toString()+System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity.getId();
    }

    @Override
    public Entity read(Integer id) throws IOException {
        checkFile();
        Entity entity = null;
        Parser parser = new Parser();
        BufferedReader bReader = new BufferedReader(new FileReader(TextDao.getFileLocation()));
        String line;
        while ((line = bReader.readLine()) != null) {
            if ((!line.isEmpty()) && (parser.parse(line).getId().equals(id))) {
                entity = parser.parse(line);
            }

        }
        bReader.close();
        return  entity;
    }

    public List<Entity> readAll() throws IOException {
        checkFile();
        List<Entity> entitys = new ArrayList();
        Entity entity = null;
        Parser parser = new Parser();
        BufferedReader bReader = new BufferedReader(new FileReader(TextDao.getFileLocation()));
        String line;
        while ((line = bReader.readLine()) != null) {
            if (!line.isEmpty()) {
                entity = parser.parse(line);
            }

            entitys.add(entity);
        }
        bReader.close();
        return  entitys;

    }




    @Override
    public void update(Entity entity) throws IOException {
        checkFile();
        List<Entity> entities = readAll();
        Entity entityToUpdate = null;
        for (Entity entity1:entities) {
            if (entity1.getId().equals(entity.getId())){
                entityToUpdate = entity1;
            }
        }
        delete(entityToUpdate);
        create(entity);

    }

    @Override
    public void delete(Entity entity) throws IOException {
        checkFile();
        File fileTxt = new File(TextDao.getFileLocation());
        List<Entity> entities = readAll();
            entities.remove(entity);
        fileTxt.delete();
            fileTxt.createNewFile();
        for (Entity entity1:entities) {
            create(entity1);
        }
    }

    public void checkFile () {
        File fileTxt = new File(TextDao.getFileLocation());
        if (!fileTxt.exists()){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(TextDao.getFileLocation(), true));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Создан файл " + TextDao.getFileLocation());

        }
    }
}