package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskCompositePanel extends JPanel {
    private final CardLayout cardLayout = new CardLayout();
    private final TaskListView listView;
    private final TaskCalendarView calendarView;

    public TaskCompositePanel(TaskListView listView, TaskCalendarView calendarView) {
        this.listView = listView;
        this.calendarView = calendarView;

        setLayout(cardLayout);
        add(listView, "LIST");
        add(calendarView, "CALENDAR");
    }

    public void showListView() {
        cardLayout.show(this, "LIST");
    }

    public void showCalendarView() {
        cardLayout.show(this, "CALENDAR");
    }
}
