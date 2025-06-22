package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TaskList extends Observable {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        setChanged();
        notifyObservers();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        setChanged();
        notifyObservers();
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
