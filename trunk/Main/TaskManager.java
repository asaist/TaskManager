public class TaskManager {
    public static void main (String[]args) {
        ConsoleInput newInput = new ConsoleInput();
        String nameTask = newInput.taskNameInput();
        System.out.println(nameTask);
    }
}
