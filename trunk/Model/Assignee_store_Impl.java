package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Assignee_store_Impl extends Observable implements Assignee_store {
    private List<Observer> assaignees = new ArrayList();
    public void create(){
        System.out.println("Запись добавлена.");
    }
}
