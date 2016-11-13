package com.github.aelmod.geekhub.homework4.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Євгеній on 13.11.2016.
 */
public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, Task> tasksList = new HashMap<>();
    private Set<String> categoriesList = new HashSet<>();


    @Override
    public void add(LocalDateTime date, Task task) {
        tasksList.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasksList.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        return categoriesList;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> res = new HashMap<>();
        for (String category : categories) {
            res.put(category, getTasksByCategory(category));
        }
        return res;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return tasksList.values().stream()
                .filter(task -> task.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksForToday() {
        LocalDate today = LocalDateTime.now().toLocalDate();
        List<Task> res = new ArrayList<>();
        for (LocalDateTime localDateTime : tasksList.keySet()) {
            if (localDateTime.toLocalDate().equals(today)) {
                res.add(tasksList.get(localDateTime));
            }
        }
        return res;
    }

}
