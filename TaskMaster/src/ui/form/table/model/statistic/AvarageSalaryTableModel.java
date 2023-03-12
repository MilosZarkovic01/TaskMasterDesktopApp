/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.table.model.statistic;

import java.math.BigDecimal;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class AvarageSalaryTableModel extends AbstractTableModel {

    public Map<String, BigDecimal> avarageSalary;
    private final String[] columnNames = {"Project name", "Avarage salary"};

    public AvarageSalaryTableModel(Map<String, BigDecimal> avarageSalary) {
        this.avarageSalary = avarageSalary;
    }

    @Override
    public int getRowCount() {
        return avarageSalary.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String projectName = (String) avarageSalary.keySet().toArray()[rowIndex];
        BigDecimal averageSalary = avarageSalary.get(projectName);

        switch (columnIndex) {
            case 0:
                return projectName;
            case 1:
                return averageSalary;
            default:
                throw new IndexOutOfBoundsException("Invalid column index");
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
