package com.example.view;

import com.example.model.Task;
import com.example.model.TaskList;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TaskCalendarView extends JPanel implements Observer {
    private final JTextArea calendarArea = new JTextArea();
    private final TaskList model;

    public TaskCalendarView(TaskList model) {
        this.model = model;
        model.addObserver(this);

        setLayout(new BorderLayout());
        calendarArea.setEditable(false);
        add(new JScrollPane(calendarArea), BorderLayout.CENTER);
        update(model, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        List<Task> tasks = model.getTasks();
        StringBuilder sb = new StringBuilder("=== Lista de Compras ===\n");
        for (Task t : tasks) {
            sb.append("- ").append(t.toString()).append("\n");
        }
        calendarArea.setText(sb.toString());
    }
}
