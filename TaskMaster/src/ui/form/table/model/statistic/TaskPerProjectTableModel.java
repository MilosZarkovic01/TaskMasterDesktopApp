/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.table.model.statistic;

import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class TaskPerProjectTableModel extends AbstractTableModel {

    public Map<String, Integer> taskPerProject;
    private final String[] columnNames = {"Project name", "Number of tasks"};

    public TaskPerProjectTableModel(Map<String, Integer> taskPerProject) {
        this.taskPerProject = taskPerProject;
    }

    @Override
    public int getRowCount() {
        return taskPerProject.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String projectName = (String) taskPerProject.keySet().toArray()[rowIndex];
        Integer numOfTasks = taskPerProject.get(projectName);

        switch (columnIndex) {
            case 0:
                return projectName;
            case 1:
                return numOfTasks;
            default:
                throw new IndexOutOfBoundsException("Invalid column index");
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
