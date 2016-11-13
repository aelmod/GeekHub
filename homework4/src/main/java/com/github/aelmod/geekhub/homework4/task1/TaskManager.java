package com.github.aelmod.geekhub.homework4.task1;

/**
 * Created by aelmod-notebook on 12.11.2016.
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface TaskManager {

    void addCategory(String name);

    void add(LocalDateTime date, Task task);

    void remove(LocalDateTime date);

    Set<String> getCategories();

    //For next 3 methods tasks should be sorted by date
    Map<String, List<Task>> getTasksByCategories(String... categories);

    List<Task> getTasksByCategory(String category);

    List<Task> getTasksForToday();
}


