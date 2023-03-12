/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Somika
 */
public class TaskTableModel extends AbstractTableModel {

    private List<Task> tasks;
    private final String[] columnNames = {"Title", "Description", "Assigned employee", "Due date", "Project"};

    public TaskTableModel(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex == tasks.size()) {
            return "";
        }

        Task task = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return task.getTitle();
            case 1:
                return task.getDescription();
            case 2:
                if (task.getAssignedEmployee() == null) {
                    return "";
                }
                return task.getAssignedEmployee().getFullName();
            case 3:
                return task.getDueDate();
            case 4:
                if (task.getProject() == null) {
                    return "";
                }
                return task.getProject().getProjectName();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void insertNewRow() {
        tasks.add(new Task());
        fireTableDataChanged();
    }

    public void add(Task task) {
        tasks.add(task);
        fireTableDataChanged();
    }

    public void remove(Task t) {
        tasks.remove(t);
        fireTableDataChanged();
    }

    public void update() {
        fireTableDataChanged();
    }

}
