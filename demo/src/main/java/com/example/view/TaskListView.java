package com.example.view;

import com.example.model.Task;
import com.example.model.TaskList;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TaskListView extends JPanel implements Observer {
    private final JList<String> taskJList = new JList<>();
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final TaskList model;

    public TaskListView(TaskList model) {
        this.model = model;
        model.addObserver(this);

        setLayout(new BorderLayout());
        taskJList.setModel(listModel);
        add(new JScrollPane(taskJList), BorderLayout.CENTER);
        update(model, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        List<Task> tasks = model.getTasks();
        listModel.clear();
        for (Task t : tasks) {
            listModel.addElement(t.toString());
        }
    }

    public int getSelectedIndex() {
        return taskJList.getSelectedIndex();
    }
}
