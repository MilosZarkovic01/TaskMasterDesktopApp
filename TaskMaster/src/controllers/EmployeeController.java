/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import model.Employee;
import persistence.dao.EmployeeDao;
import persistence.dao.impl.EmployeeDaoImpl;

/**
 *
 * @author Somika
 */
public class EmployeeController {

    private static EmployeeController instance;
    private final EmployeeDao repositoryEmployee;

    private EmployeeController() {
        repositoryEmployee = new EmployeeDaoImpl();
    }

    public static EmployeeController getInstance() {
        if (instance == null) {
            instance = new EmployeeController();
        }
        return instance;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return repositoryEmployee.getAllEmployees();
    }

    public Employee saveEmployee(Employee employee) throws SQLException {
        return repositoryEmployee.saveEmployee(employee);
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        repositoryEmployee.deleteEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        repositoryEmployee.updateEmployee(employee);
    }

    public Map<String, Integer> getEmployeesWithMostCompletedTasksInPastMonth() throws SQLException {
        return repositoryEmployee.getEmployeesWithMostCompletedTasksInPastMonth();
    }

    public BigDecimal getAvarageSalary() throws SQLException {
        return repositoryEmployee.getAvarageSalary();
    }
}
