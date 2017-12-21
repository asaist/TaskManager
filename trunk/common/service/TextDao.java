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
    public List<Entity> read(Integer id) throws IOException {


        File file = new File(TextDao.getFileLocation());
        if (!file.exists()) {
            file.createNewFile();
        }

        List<Entity> entitys = new ArrayList<>();
        Parser parser = new Parser();
        BufferedReader bReader = new BufferedReader(new FileReader(TextDao.getFileLocation()));
        String line;
        while ((line = bReader.readLine()) != null) {
            if ((!line.isEmpty()) && (parser.parse(line).getId().equals(id))) {
                entitys.add(parser.parse(line));
            }
        }
        return entitys;
    }



    @Override
    public void update(Entity transientObject) {

    }

    @Override
    public void delete(Entity persistentObject) {

    }
}
