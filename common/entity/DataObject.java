package common.entity;

import sun.font.CreatedFontTracker;

public interface DataObject {
    enum Action {CREATE,UPDATE,DELETE,GET_LIST_ENTITY}


    void setEntity(Object entity);
    Object getEntity();
    void setAction(Action action);
    Action getAction();
}
