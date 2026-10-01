// Question: Use a PriorityQueue to store a list of tasks with priorities. Add tasks, remove the highest-priority task, and print the queue.

import java.util.PriorityQueue;

public class Q22_PriorityQueueTaskScheduler {

    // Custom Task class implementing Comparable (Lower number = Higher priority)
    static class Task implements Comparable<Task> {
        private final String taskName;
        private final int priority; // 1 = Highest, 5 = Lowest

        public Task(String taskName, int priority) {
            this.taskName = taskName;
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            // Ascending order: Priority 1 comes before Priority 2
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "Task [Name = '" + taskName + "', Priority = " + priority + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 6: Queue and Stack ---");
        System.out.println("--- Q22: PriorityQueue Task Scheduler Demo ---\n");

        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Adding tasks with different priorities
        taskQueue.offer(new Task("Security Patch Deployment", 1)); // Highest
        taskQueue.offer(new Task("Weekly Database Backup", 4));
        taskQueue.offer(new Task("Fix Critical Production Bug", 2));
        taskQueue.offer(new Task("Update API Documentation", 5)); // Lowest
        taskQueue.offer(new Task("Code Review for PR #42", 3));

        System.out.println("Tasks Added to PriorityQueue.");
        System.out.println("Current Highest Priority Task (peek()): " + taskQueue.peek() + "\n");

        System.out.println("--- Processing Tasks in Priority Order (poll()) ---");
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            System.out.println("Executing -> " + currentTask);
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
