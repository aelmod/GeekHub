package com.github.aelmod.geekhub.homework4.task1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by Євгеній on 13.11.2016.
 */
public class App {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        taskManager.addCategory("geekhub");
        taskManager.addCategory("fregat");
        taskManager.addCategory("internet");
        taskManager.add(LocalDateTime.of(2016, 11, 9, 10, 5), new Task("explode", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 11, 0), new Task("explode", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 15, 0), new Task("explode", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 9, 0), new Task("explode", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 15, 0), new Task("do home work", "fregat"));
        taskManager.add(LocalDateTime.of(2016, 11, 13, 10, 0), new Task("do home work", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 14, 16, 0), new Task("do home work", "geekhub"));
        taskManager.add(LocalDateTime.of(2016, 11, 15, 11, 0), new Task("do home work", "internet"));
        taskManager.add(LocalDateTime.of(2016, 11, 16, 17, 0), new Task("do home work", "internet"));

        System.out.println("Categories: ");
        printCategories(taskManager);
        System.out.println("\nTasks for today: ");
        printTasksForToday(taskManager);

        printTasksByCategories(taskManager);

    }

    private static void printTasksByCategories(TaskManager taskManager) {
        for (Entry<String, List<Task>> tasks : taskManager.getTasksByCategories("geekhub", "internet").entrySet()) {
            System.out.println("\nTasks by category " + tasks.getKey() + ": ");
            for (Task task : tasks.getValue()) {
                System.out.print("\t" + task.getName());
            }
        }
    }

    private static void printTasksForToday(TaskManager taskManager) {
        for (Task task : taskManager.getTasksForToday()) {
            System.out.println("\t" + task.getName());
        }
    }

    private static void printCategories(TaskManager taskManager) {
        taskManager.getCategories().forEach(System.out::println);
    }

}
