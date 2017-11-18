import java.util.Scanner;
public class ConsoleInput {
    Scanner scanner = new Scanner(System.in);
    public String taskNameInput () {
        System.out.println("Input task name ");
        String nameTask = scanner.nextLine();
        return nameTask;
    }
}
