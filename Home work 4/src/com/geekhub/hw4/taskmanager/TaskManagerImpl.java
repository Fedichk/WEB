package com.geekhub.hw4.taskmanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class TaskManagerImpl implements TaskManager {

    Map<LocalDateTime, Task> tasksByDateMap = new TreeMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        tasksByDateMap.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasksByDateMap.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        Set<String> taskCategories = new TreeSet<>();
        for (Map.Entry<LocalDateTime, Task> element : tasksByDateMap.entrySet()) {
            taskCategories.add(element.getValue().getCategory());
        }
        return taskCategories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> tasksByCategoriesMap = new TreeMap<>();
        for (String categori : categories) {
            tasksByCategoriesMap.put(categori, new TaskManagerImpl().getTasksByCategory(categori));
        }
        return tasksByCategoriesMap;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasks = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Task> element : tasksByDateMap.entrySet()) {
            if (element.getValue().getCategory().equals(category)) {
                tasks.add(element.getValue());
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasks = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Map.Entry<LocalDateTime, Task> element : tasksByDateMap.entrySet()) {
            if ((ChronoUnit.DAYS.between(element.getKey(), today) == 0)) {
                tasks.add(element.getValue());
            }
        }
        return tasks;
    }
}
