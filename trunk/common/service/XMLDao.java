package common.service;

import common.entity.Entity;

import java.io.IOException;
import java.util.List;

public class XMLDao implements GenericDao {
    @Override
    public Integer create(Entity newInstance) {
        return null;
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
    public List<Entity> readAll() throws IOException {
        return null;
    }

    @Override
    public void checkFile() {

    }
}
