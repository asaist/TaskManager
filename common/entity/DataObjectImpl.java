package common.entity;

public class DataObjectImpl implements DataObject {
    Object entities;
    String action;

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
