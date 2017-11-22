import java.util.Observable;

public class Assignee_store_Impl extends Observable implements Assignee_store {
    public void create(){
        System.out.println("Запись добавлена.");
    }
}
