// Question: Implement a basic to-do list application using ArrayList to store tasks. Add functionality to add, remove, and display tasks.

import java.util.ArrayList;
import java.util.List;

public class Q37_TodoListArrayList {

    static class TodoApp {
        private final List<String> taskList = new ArrayList<>();

        public void addTask(String task) {
            taskList.add(task);
            System.out.println("  [+] Added Task: \"" + task + "\"");
        }

        public boolean removeTaskByIndex(int index) {
            if (index >= 0 && index < taskList.size()) {
                String removed = taskList.remove(index);
                System.out.println("  [-] Removed Task at index " + index + ": \"" + removed + "\"");
                return true;
            } else {
                System.out.println("  [!] Invalid index: " + index);
                return false;
            }
        }

        public boolean removeTaskByName(String taskName) {
            boolean removed = taskList.remove(taskName);
            if (removed) {
                System.out.println("  [-] Removed Task: \"" + taskName + "\"");
            } else {
                System.out.println("  [!] Task not found: \"" + taskName + "\"");
            }
            return removed;
        }

        public void displayTasks() {
            System.out.println("\n--- Current To-Do List (" + taskList.size() + " Tasks) ---");
            if (taskList.isEmpty()) {
                System.out.println("  (Your To-Do list is empty!)");
                return;
            }
            for (int i = 0; i < taskList.size(); i++) {
                System.out.printf("  [%d] %s%n", (i + 1), taskList.get(i));
            }
            System.out.println("------------------------------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 11: Practical Use Cases ---");
        System.out.println("--- Q37: To-Do List Application using ArrayList ---\n");

        TodoApp app = new TodoApp();

        // 1. Adding Tasks
        System.out.println("1. Adding Tasks:");
        app.addTask("Complete Java Module 4 Assignment");
        app.addTask("Study for Operating Systems Midterm");
        app.addTask("Review Git Branching and Pull Requests");
        app.addTask("Buy Groceries and Snacks");

        // 2. Display Tasks
        app.displayTasks();

        // 3. Removing Tasks
        System.out.println("\n2. Removing Completed Tasks:");
        app.removeTaskByIndex(1); // Removes "Study for Operating Systems Midterm"
        app.removeTaskByName("Buy Groceries and Snacks");

        // 4. Display Updated List
        app.displayTasks();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
