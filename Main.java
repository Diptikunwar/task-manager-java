import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    manager.addTask(title, desc);
                    break;
                case 2:
                    manager.viewTasks();
                    break;
                case 3:
                    System.out.print("Task ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New Description: ");
                    String newDesc = sc.nextLine();
                    System.out.print("Completed (true/false): ");
                    boolean completed = sc.nextBoolean();
                    manager.updateTask(id, newTitle, newDesc, completed);
                    break;
                case 4:
                    System.out.print("Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
