package com.example;

import com.example.controller.TaskCalendarController;
import com.example.controller.TaskController;
import com.example.controller.TaskListController;
import com.example.model.TaskList;
import com.example.view.TaskCalendarView;
import com.example.view.TaskCompositePanel;
import com.example.view.TaskListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    private static TaskController currentController;
    private static TaskList model = new TaskList();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rennerson - Lista de Compras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            TaskListView listView = new TaskListView(model);
            TaskCalendarView calendarView = new TaskCalendarView(model);

            TaskCompositePanel compositePanel = new TaskCompositePanel(listView, calendarView);

            TaskListController listController = new TaskListController(model);
            TaskCalendarController calendarController = new TaskCalendarController(model);

            currentController = listController;
            compositePanel.showListView();

            JPanel topPanel = new JPanel(new FlowLayout());

            JButton addButton = new JButton("Adicionar Tarefa");
            JButton removeButton = new JButton("Remover Selecionado");
            JButton switchViewButton = new JButton("Alternar Visualização");

            topPanel.add(addButton);
            topPanel.add(removeButton);
            topPanel.add(switchViewButton);

            frame.setLayout(new BorderLayout());
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(compositePanel, BorderLayout.CENTER);

            addButton.addActionListener((ActionEvent e) -> {
                String taskTitle = JOptionPane.showInputDialog(frame, "Título da Tarefa:");
                if (taskTitle != null && !taskTitle.trim().isEmpty()) {
                    currentController.addTask(taskTitle.trim());
                }
            });

            removeButton.addActionListener((ActionEvent e) -> {
                int idx;
                if (currentController instanceof TaskListController) {
                    idx = listView.getSelectedIndex();
                } else {
                    JOptionPane.showMessageDialog(frame, "Remoção permitida apenas na Visualização de Lista!");
                    return;
                }
                if (idx >= 0) {
                    currentController.removeTask(idx);
                }
            });

            switchViewButton.addActionListener((ActionEvent e) -> {
                if (currentController == listController) {
                    currentController = calendarController;
                    compositePanel.showCalendarView();
                } else {
                    currentController = listController;
                    compositePanel.showListView();
                }
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
