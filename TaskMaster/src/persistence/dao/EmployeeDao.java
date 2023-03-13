/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence.dao;

import java.math.BigDecimal;
import java.util.List;
import model.Employee;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 *
 * @author Somika
 */
public interface EmployeeDao {
    public List<Employee> getAllEmployees() throws SQLException;
    public Employee saveEmployee(Employee employee) throws SQLException;
    public void deleteEmployee(Employee employee) throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
    public BigDecimal getAvarageSalary() throws SQLException;
    public LinkedHashMap<String, Integer> getEmployeesWithMostCompletedTasksInPastMonth() throws SQLException;
}
