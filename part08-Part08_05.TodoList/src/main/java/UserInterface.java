
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoList toDoList;

    public UserInterface(TodoList toDoList, Scanner scanner) {
        this.scanner = scanner;
        this.toDoList = toDoList;
    }
    
    public void start() {
        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("stop")) {
                break;
            }
            if (cmd.equals("add")) {
                System.out.print("To add: ");
                String toDo = scanner.nextLine();
                toDoList.add(toDo);
            }
            if (cmd.equals("remove")) {
                System.out.print("Which one is removed? ");
                int number = Integer.valueOf(scanner.nextLine());
                toDoList.remove(number);
            }
            if (cmd.equals("list")) {
                toDoList.print();
            }
        }
    }
    
}
