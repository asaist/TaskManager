package common.entity;

import java.io.InputStream;
import java.io.OutputStream;

public class DataObjectImpl implements DataObject {
    Object entities;
    String action;

    public DataObjectImpl(InputStream sin) {
    }

    public DataObjectImpl(OutputStream sout) {
    }

    @Override
    public void setEntities(Object entities) {
        this.entities=entities;
    }

    @Override
    public Object getEntities() {
        return entities;
    }

    @Override
    public void setAction(String action) {
        this.action=action;
    }

    @Override
    public String getAction() {
        return action;
    }
}
