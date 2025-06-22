package com.example.controller;

import com.example.model.Task;
import com.example.model.TaskList;

public class TaskCalendarController implements TaskController {
    private final TaskList model;

    public TaskCalendarController(TaskList model) {
        this.model = model;
    }

    @Override
    public void addTask(String title) {
        model.addTask(new Task(title + " (calendar)"));
    }

    @Override
    public void removeTask(int index) {
        if (index >= 0 && index < model.getTasks().size()) {
            model.removeTask(model.getTasks().get(index));
        }
    }
}
