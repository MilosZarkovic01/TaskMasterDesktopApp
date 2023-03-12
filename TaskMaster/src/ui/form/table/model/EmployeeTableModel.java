/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Employee;
import model.Task;

/**
 *
 * @author Somika
 */
public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> employees;
    private final String[] columnNames = {"Full name", "Email", "Phone number", "Date of birth", "Monthly salary", "Tasks"};

    public EmployeeTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getFullName();
            case 1:
                return employee.getEmail();
            case 2:
                return employee.getPhoneNumber();
            case 3:
                return employee.getDateOfBirth();
            case 4:
                return employee.getMonthlySalary();
            case 5:
                StringBuilder allTasks = new StringBuilder();
                for (Task task : employee.getTasks()) {
                    allTasks.append(task.getTitle()).append(", ");
                }
                if (allTasks.length() == 0) {
                    return "No assigned tasks";
                } else {
                    allTasks.setLength(allTasks.length() - 2); // Removes the last comma and whitespace.
                    return allTasks.toString();
                }
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
        fireTableDataChanged();
    }

    public void remove(Employee employee) {
        employees.remove(employee);
        fireTableDataChanged();
    }
}
