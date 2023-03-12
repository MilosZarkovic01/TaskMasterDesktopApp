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
public class Top5EmployeesTableModel extends AbstractTableModel {

    public Map<String, Integer> top5Employees;
    private final String[] columnNames = {"Full name", "Number of tasks"};

    public Top5EmployeesTableModel(Map<String, Integer> top5Employees) {
        this.top5Employees = top5Employees;
    }

    @Override
    public int getRowCount() {
        return top5Employees.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String fullName = (String) top5Employees.keySet().toArray()[rowIndex];
        Integer numOfTasks = top5Employees.get(fullName);

        switch (columnIndex) {
            case 0:
                return fullName;
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
