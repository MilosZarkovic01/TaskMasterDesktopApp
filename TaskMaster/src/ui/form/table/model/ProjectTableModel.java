/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Project;
import model.Task;

/**
 *
 * @author Somika
 */
public class ProjectTableModel extends AbstractTableModel {

    private List<Project> projects;
    private final String[] columnNames = {"Project name", "Description", "Start date", "End date", "Budget", "Tasks"};

    public ProjectTableModel(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int getRowCount() {
        return projects.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project project = projects.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return project.getProjectName();
            case 1:
                return project.getDescription();
            case 2:
                return project.getStartDate();
            case 3:
                return project.getEndDate();
            case 4:
                return project.getBudget();
            case 5:
                StringBuilder allTasks = new StringBuilder();
                for (Task task : project.getTasks()) {
                    allTasks.append(task.getTitle()).append(", ");
                }
                if (allTasks.length() == 0) {
                    return "No tasks assigned to this project";
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

    public List<Project> getProjects() {
        return projects;
    }

    public void remove(Project project) {
        projects.remove(project);
        fireTableDataChanged();
    }

}
