package common.entity;

public interface DataObject {
    Object entities=null;
    String action="";

    void setEntities(Object entities);
    Object getEntities();
    void setAction(String action);
    String getAction();
}
