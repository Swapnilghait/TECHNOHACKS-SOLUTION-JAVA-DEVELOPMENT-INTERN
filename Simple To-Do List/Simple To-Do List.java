import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting To-Do List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. View tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addTask() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void removeTask() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the task number to remove: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid task number: ");
            scanner.next();
        }
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void viewTasks() {
        System.out.println("\nTo-Do List:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
