import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = TaskFileHandler.loadTasks();
        nextId = tasks.size() + 1;
    }

    public void addTask(String title, String description) {
        Task task = new Task(nextId++, title, description, false);
        tasks.add(task);
        TaskFileHandler.saveTasks(tasks);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
            System.out.println("----------------------");
        }
    }

    public void updateTask(int id, String title, String description, boolean completed) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(description);
                task.setCompleted(completed);
                TaskFileHandler.saveTasks(tasks);
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        TaskFileHandler.saveTasks(tasks);
        System.out.println("Task deleted successfully.");
    }
}
