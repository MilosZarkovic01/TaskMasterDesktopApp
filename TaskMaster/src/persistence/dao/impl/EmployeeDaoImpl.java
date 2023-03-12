/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Project;
import model.Task;
import persistence.connection.DBConnectionFactory;
import persistence.dao.EmployeeDao;

/**
 *
 * @author Somika
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT e.*, t.*, p.* FROM employee e\n"
                + "LEFT JOIN task t\n"
                + "ON t.assigned_employee_fk = e.id\n"
                + "LEFT JOIN project p\n"
                + "ON t.project_fk = p.id";

        Map<Long, Employee> employeeMap = new HashMap<>();
        Connection conn = null;

        try {
            conn = DBConnectionFactory.getInstance().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement stmt = conn.createStatement();
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long employeeId = rs.getLong("e.id");
                Employee employee;
                if (!employeeMap.containsKey(employeeId)) {
                    employee = new Employee();
                    employee.setId(employeeId);
                    employee.setFullName(rs.getString("e.full_name"));
                    employee.setEmail(rs.getString("e.email"));
                    employee.setPhoneNumber(rs.getString("e.phone_number"));
                    employee.setDateOfBirth(rs.getDate("e.date_of_birth").toLocalDate());
                    employee.setMonthlySalary(BigDecimal.valueOf(rs.getDouble("e.monthly_salary")));
                    employeeMap.put(employeeId, employee);
                } else {
                    employee = employeeMap.get(employeeId);
                }

                // Set tasks for employee
                Long taskId = rs.getLong("t.id");
                if (taskId != 0) {
                    Task task = new Task();
                    task.setId(taskId);
                    task.setTitle(rs.getString("t.title"));
                    task.setDescription(rs.getString("t.description"));
                    task.setDueDate(rs.getDate("t.due_date").toLocalDate());
                    task.setAssignedEmployee(employee);

                    // Set project for task
                    Project project = new Project();
                    project.setId(rs.getLong("p.id"));
                    project.setProjectName(rs.getString("p.project_name"));
                    project.setDescription(rs.getString("p.description"));
                    project.setStartDate(rs.getDate("p.start_date").toLocalDate());
                    project.setEndDate(rs.getDate("p.end_date").toLocalDate());
                    project.setBudget(BigDecimal.valueOf(rs.getDouble("p.budget")));
                    task.setProject(project);

                    employee.getTasks().add(task);
                }
            }
        }
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
        try {
            String sql = "INSERT INTO employee(full_name, email, phone_number, date_of_birth, monthly_salary) VALUES(?,?,?,?,?);";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPhoneNumber());
            preparedStatement.setDate(4, java.sql.Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.setBigDecimal(5, employee.getMonthlySalary());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                Long generatedId = rs.getLong(1);
                employee.setId(generatedId);
            }

            preparedStatement.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee) throws SQLException {
        try {
            String sql = "DELETE FROM employee WHERE id = ?";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        try {
            String sql = "UPDATE employee SET full_name = ?, email = ?, phone_number = ?, date_of_birth = ?,  monthly_salary = ? WHERE id = ?";
            Connection connection = DBConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFullName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhoneNumber());
            ps.setDate(4, java.sql.Date.valueOf(employee.getDateOfBirth()));
            ps.setBigDecimal(5, employee.getMonthlySalary());
            ps.setLong(6, employee.getId());

            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BigDecimal getAvarageSalary() throws SQLException {
        BigDecimal avarageSalary = null;
        try {
            String sql = "SELECT AVG(monthly_salary) FROM employee";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            avarageSalary = BigDecimal.valueOf(rs.getDouble(1));

            statement.close();
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avarageSalary;
    }

    @Override
    public Map<String, Integer> getEmployeesWithMostCompletedTasksInPastMonth() throws SQLException {
        Map<String, Integer> employeesWithMostCompletedTasks = new HashMap<>();
        try {
            String sql = "SELECT e.full_name, COUNT(*) AS num_tasks_completed\n"
                    + "FROM Employee e\n"
                    + "INNER JOIN Task t ON e.id = t.assigned_employee_fk\n"
                    + "WHERE t.due_date >= DATE_ADD(NOW(), INTERVAL -1 MONTH)\n"
                    + "GROUP BY e.id, e.full_name\n"
                    + "ORDER BY num_tasks_completed DESC\n"
                    + "LIMIT 5;";
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String fullName = rs.getString(1);
                Integer numOfTasks = rs.getInt(2);
                employeesWithMostCompletedTasks.put(fullName, numOfTasks);
            }

            statement.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeesWithMostCompletedTasks;
    }
}
